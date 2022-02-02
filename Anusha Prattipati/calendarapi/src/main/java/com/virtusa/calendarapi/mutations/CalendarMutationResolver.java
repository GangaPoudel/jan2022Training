package com.virtusa.calendarapi.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.models.CalendarInput;
import com.virtusa.calendarapi.services.CalendarService;


@Component
	public class CalendarMutationResolver implements GraphQLMutationResolver {
	    @Autowired
	    private CalendarService calendarService;

	    public Calendar createCalendar(CalendarInput calendarInput){
	       
	    	return this.calendarService.addCalendar(new Calendar(0,calendarInput.getCalendarCategory(),calendarInput.getCalendarEvent(),calendarInput.getDateHoliday(),calendarInput.getCalendarCountrycode()));
	    }

	    public Calendar updateCalendar(long holidayId, String calendarEvent){
	        return this.calendarService.updateCalendar(holidayId, calendarEvent);
	    }

	    public Boolean deleteCalendar(long holidayId){
	        return this.calendarService.deleteHolidayById(holidayId);
	    }
	}

