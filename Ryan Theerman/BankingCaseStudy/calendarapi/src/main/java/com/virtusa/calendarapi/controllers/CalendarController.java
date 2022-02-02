package com.virtusa.calendarapi.controllers;

import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.services.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendars")
@RefreshScope
@Slf4j
public class CalendarController {

    @Autowired
    private CalendarService calendarService;

    @Value(("${newmessage}"))
    private String message;

    //get
    @GetMapping(value="/",params="version=1.0")
    public List<Calendar> getAllHolidays() {
        log.info("Message: " + message);
        return this.calendarService.getAllHolidays();
    }

    @GetMapping(value="/{holidayId}",params="version=1.0")
    public ResponseEntity<?> getHolidayById(@PathVariable("holidayId") long holidayId) {
        Calendar calendarObj=this.calendarService.getHolidayById(holidayId);
        if(calendarObj!=null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Holiday Not Found");
        }
    }

    //post
    @PostMapping(value = "/",params="version=1.0")
    public ResponseEntity<?> addHoliday(@RequestBody Calendar calendar) {
        Calendar calendarObj=this.calendarService.addHoliday(calendar);
        if(calendarObj!=null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Holiday Not Created");
        }
    }

    //put
    @PutMapping(value="/{holidayId}/{category}",params = "version=1.0")
    public ResponseEntity<?> updateHoliday(@PathVariable("holidayId") long holidayId, @PathVariable("category") String category){
        Calendar calendarObj=this.calendarService.updateHoliday(holidayId, category);
        if(calendarObj!=null) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Holiday Not Created");
        }
    }

    //delete
    @DeleteMapping(value="/{holidayId}",params="version=1.0")
    public ResponseEntity<?> deleteHolidayById(@PathVariable("holidayId") long holidayId) {
        if(this.calendarService.deleteHolidayById(holidayId)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Holiday with id "+holidayId+" deleted");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Holiday Not Found");
        }
    }
}