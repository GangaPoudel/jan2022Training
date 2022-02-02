package com.ganga.calenderapi.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.ganga.calenderapi.services.CalenderService;
import com.ganga.calenderapi.services.models.Calender;


@RestController
@RequestMapping("/calenders")
public class CalenderController {
	
	@Autowired
	private CalenderService calenderService;
	
	//post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addCalender(@RequestBody Calender calender){
		Calender calObj=this.calenderService.addCalender(calender);
		if(calObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Created");
		
	}
	
	//get
	@GetMapping(value="/",params = "version=1.0")
	public List<Calender> getAllCalenders(){
		return this.calenderService.getAllCalenders();
	}
	
	//get with id
	
	@GetMapping(value="/{id}",params = "version=1.0")
	public ResponseEntity<?> getCalenderById(@PathVariable("id") long id){
		Calender calObj=this.calenderService.getCalenderById(id);
		if(calObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Found");
		
	}
	
	
	//put
	
	@PutMapping(value="/{id}/{event}",params = "version=1.0")
	public ResponseEntity<?> updateCalender(@PathVariable("id") long id,@PathVariable("event") String event){
		Calender calObj=this.calenderService.updateCalender(id,event);
		if(calObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Created");
		
	}
	
	
	//delete
	
	@DeleteMapping(value="/{id}",params = "version=1.0")
	public ResponseEntity<?> deleteCalenderById(@PathVariable("id") long id){
	
		if(this.calenderService.deleteCalenderById(id))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Calender with "+id+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Found");
		
	}
	

}
