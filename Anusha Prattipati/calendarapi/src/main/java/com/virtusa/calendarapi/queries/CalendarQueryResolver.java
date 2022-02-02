package com.virtusa.calendarapi.queries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.services.CalendarService;

import java.util.List;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;



@Component
	public class CalendarQueryResolver implements GraphQLQueryResolver {
	    @Autowired
	    private CalendarService calendarService;

	    public List<Calendar> findAllCalendars(){
	        return this.calendarService.getAllCalendar();
	    }

	    public Calendar findHolidayById(long holidayId){
	        return this.calendarService.getHolidayById(holidayId);
	    }

	}

