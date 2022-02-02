package com.example.calendar.controllers;

import com.example.calendar.models.Calendar;
import com.example.calendar.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    private CalendarService calendarService;

    // Post
    @PostMapping(value = "/", params = "version=1.0")
    public ResponseEntity<?> addCalendar(@RequestBody Calendar calendar) {
        Calendar calendarObj = this.calendarService.addCalendar(calendar);
        if (calendarObj != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calendar not created");
    }

    // Get
    @GetMapping(value = "/", params = "version=1.0")
    public List<Calendar> getAllCurrencies() {
        return this.calendarService.getAllCalendar();
    }

    // Get with Id
    @GetMapping(value = "/{calendarId}", params = "version=1.0")
    public ResponseEntity<?> getCalendarById(@PathVariable("calendarId") long calendarId) {
        Calendar calendarObj = this.calendarService.getCalendarById(calendarId);
        if (calendarObj != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calendar not found");
    }

    // Put
    @PutMapping(value = "/{calendarId}", params = "version=1.0")
    public ResponseEntity<?> updateCalendar(@RequestParam("calendarId") long calendarId,
            @RequestBody Calendar calendar) {
        Calendar calendarObj = this.calendarService.updateCalendar(calendarId, calendar);
        if (calendarObj != null)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(calendarObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calendar not found");

    }

    // Delete
    @DeleteMapping(value = "/{calendarId}", params = "version=1.0")
    public ResponseEntity<?> deleteCalendar(@PathVariable("calendarId") long calendarId) {
        boolean result = this.calendarService.deleteCalendarById(calendarId);
        if (result)
            return ResponseEntity.ok("Successfully Deleted");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Calendar not deleted/Not Found");
    }
}
