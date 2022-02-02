package com.virtusa.calendar.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.calendar.models.Calendar;
import com.virtusa.calendar.models.CalendarInput;
import com.virtusa.calendar.services.CalendarService;

@Component
public class CalendarMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CalendarService calendarService;
	
	public Calendar createHoliday(CalendarInput calendarInput) {
		return this.calendarService.addHoliday(new Calendar(0, calendarInput.getEvent(), calendarInput.getCategory(), calendarInput.getDateHoliday()));
	}
	
	public Calendar updateHoliday(long holidayId, String event) {
		return this.calendarService.updateHoliday(holidayId, event);
	}

}
