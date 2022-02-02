package com.example.calendar.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.calendar.models.Calendar;
import com.example.calendar.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalenderQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private CalendarService calendarService;

    public List<Calendar> findAllCalendars(){
        return this.calendarService.getAllCalendar();
    }

    public Calendar findCalendarById(long calendarId){
        return this.calendarService.getCalendarById(calendarId);
    }

}
