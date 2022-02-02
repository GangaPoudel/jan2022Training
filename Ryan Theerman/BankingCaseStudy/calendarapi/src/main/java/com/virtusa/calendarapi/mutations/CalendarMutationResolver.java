package com.virtusa.calendarapi.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.models.CalendarInput;
import com.virtusa.calendarapi.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalendarMutationResolver implements GraphQLMutationResolver{
	@Autowired
	private CalendarService calendarService;

	//create
	public Calendar createHoliday(CalendarInput calendarInput) {
		return this.calendarService.addHoliday(new Calendar(
				calendarInput.getEvent(),
				calendarInput.getCategory(),
				calendarInput.getDateHoliday(),
				calendarInput.getCountryCode()));
	}

	//update
	public Calendar updateHoliday(long holidayId, String category) {
		return this.calendarService.updateHoliday(holidayId, category);
	}

	//delete
	public Boolean deleteHoliday(Long holidayId) {
		return this.calendarService.deleteHolidayById(holidayId);
	}

}
