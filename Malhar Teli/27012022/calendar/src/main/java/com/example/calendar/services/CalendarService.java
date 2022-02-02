package com.example.calendar.services;

import com.example.calendar.models.Calendar;
import com.example.calendar.repositories.CalendarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {
    @Autowired
    private CalendarRepo calendarRepo;

    // insert
    public Calendar addCalendar(Calendar calendar) {
        return this.calendarRepo.save(calendar);
    }

    // update
    public Calendar updateCalendar(long calendarId, Calendar calendar) {
        Calendar calendarObj = this.getCalendarById(calendarId);
        if (calendarObj != null) {

        }
        return this.calendarRepo.save(calendar);
    }

    // List all
    public List<Calendar> getAllCalendar() {
        return this.calendarRepo.findAll();
    }

    public Calendar getCalendarById(long calendarId) {
        return this.calendarRepo.findById(calendarId).orElse(null);
    }

    public boolean deleteCalendarById(long calendarId) {
        this.calendarRepo.deleteById(calendarId);
        return (this.getCalendarById(calendarId) == null);
    }
}
