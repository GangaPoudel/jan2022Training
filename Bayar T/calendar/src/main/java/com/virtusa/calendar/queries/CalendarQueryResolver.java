package com.virtusa.calendar.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.calendar.models.Calendar;
import com.virtusa.calendar.services.CalendarService;

@Component
public class CalendarQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private CalendarService calendarService;
	
	public List<Calendar> findAllHolidays() {
		return this.calendarService.getAllHolidays();
	}
	
	public Calendar findHoliday(long holidayId) {
		return this.calendarService.getHolidayById(holidayId);
	}

}
