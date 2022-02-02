package com.virtusa.calendar.controllers;

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

import com.virtusa.calendar.models.Calendar;
import com.virtusa.calendar.services.CalendarService;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
	@Autowired
	private CalendarService calendarService;


	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addHoliday(@RequestBody Calendar calendar) {
		Calendar calendarObj = this.calendarService.addHoliday(calendar);
		if(calendarObj != null) 
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Holiday Not Created");
	}
	
	@GetMapping(value="/",params = "version=1.0")
	public List<Calendar> getAllHolidays() {
		return this.calendarService.getAllHolidays();
	}
	
	@GetMapping(value="/{holidayId}", params = "version=1.0")
	public ResponseEntity<?> getHolidayById(@PathVariable("holidayId") long holidayId) {
		Calendar calendarObj = this.calendarService.getHolidayById(holidayId);
		if(calendarObj != null)
			return  ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Holiday does not exist");
	}
	
	@PutMapping(value="/{holidayId}/{event}",params = "version=1.0")
	public ResponseEntity<?> updateHoliday(@PathVariable("holidayId") long holidayId, @PathVariable("event") String event){
		Calendar calendarObj=this.calendarService.updateHoliday(holidayId, event);
		if(calendarObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Holiday Not Created");
		
	}
	
	@DeleteMapping(value="/{holidayId}",params = "version=1.0")
	public ResponseEntity<?> deleteHolidayById(@PathVariable("holidayId") long holidayId){
		if(this.calendarService.deleteHolidayById(holidayId))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Holiday with "+holidayId+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Holiday Not Found");
		
	}
}
