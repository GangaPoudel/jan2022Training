package com.calender.CalenderApi.controllers;

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

import com.calender.CalenderApi.modules.Calender;
import com.calender.CalenderApi.services.CalenderServices;



@RestController
@RequestMapping("/calenders")
public class CalenderControllers {
	
	@Autowired
	private CalenderServices calenderservice;
	
	//post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addCustomer(@RequestBody Calender calender){
		Calender calenderObj=this.calenderservice.addCalender(calender);
		if(calenderObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calenderObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Created");
		
	}
	//get
	@GetMapping(value="/",params = "version=1.0")
	public List<Calender> getAllCalenders(){
		return this.calenderservice.getAllCalenders();
	}
	
	//get with id
	
	@GetMapping(value="/{calenderId}",params = "version=1.0")
	public ResponseEntity<?> getHolidayById(@PathVariable("holidayId") long holidayId){
		Calender calenderObj=this.calenderservice.getHolidayById(holidayId);
		if(calenderObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calenderObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Found");
		
	}
	
	
	//put
	
	@PutMapping(value="/{holidayId}/{event}",params = "version=1.0")
	public ResponseEntity<?> updateCalender(@PathVariable("holidayId") long holidayId,@PathVariable("event") String event){
		Calender calenderObj=this.calenderservice.updateCalender(holidayId,event);
		if(calenderObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calenderObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calender Not Created");
		

}
}