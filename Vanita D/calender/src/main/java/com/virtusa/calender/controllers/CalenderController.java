package com.virtusa.calender.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.virtusa.calender.models.Calender;
import com.virtusa.calender.services.CalenderService;


@RestController
@RequestMapping("/calenders")
public class CalenderController {
	@Autowired
	private CalenderService cService;
	
	//post
	@PostMapping(value = "/", params = "version=1.0")
	public ResponseEntity<?> addCalender(@RequestBody Calender calender){
		Calender calenderObj = this.cService.addCalender(calender);
		if(calenderObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calenderObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Created");
	}
	//get//why are we not returning responseentity?
	@GetMapping(value="/",params = "version=1.0")
	public List<Calender> getAllCalender(){
		return this.cService.getAllCalenders();
	}
	
	//get with id
	
	@GetMapping(value="/{calenderId}",params = "version=1.0")
	public ResponseEntity<?> getCalenderById(@PathVariable("calenderId") long calenderId){
		Calender calenderObj=this.cService.getCalenderById(calenderId);
		if(calenderObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calenderObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Found");
		
	}
	@PutMapping(value="/{calenderId}/{category}",params = "version=1.0")
	public ResponseEntity<?> updateCalender(@PathVariable("calenderId") long calenderId,@PathVariable("category") String category){
		Calender CalenderObj = this.cService.updateCalender(calenderId, category);
		if(CalenderObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(CalenderObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender not updated");
		
	}
	
	
	//delete
	
	@DeleteMapping(value="/{calenderId}",params = "version=1.0")
	public ResponseEntity<?> deleteCalenderById(@PathVariable("calenderId") long calenderId){
	
		if(this.cService.deleteCalenderById(calenderId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Calender with "+ calenderId+" Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Found");
		
	}
	//get calender by needed fields
	@GetMapping(value = "/filters/{calenderId}", params = "version=1.0")
	public ResponseEntity<?> getCalenderByFields(@PathVariable("calenderId") Long calenderId, @RequestParam(name="fields",required = false) String fields){
		Map<Object, Object> model = new HashMap<>();
		Calender calender = this.cService.getCalenderById(calenderId);
		if(calender != null) {
			ObjectMapper mapper = Squiggly.init(new ObjectMapper(), fields);
			return ResponseEntity.ok(SquigglyUtils.stringify(mapper, calender));
		} else {
			model.put("message", "Calender Not Found");
			return ResponseEntity.ok(model);
		}
	}
}
