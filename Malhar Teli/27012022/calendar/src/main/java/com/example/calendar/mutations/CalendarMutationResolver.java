package com.example.calendar.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.calendar.models.Calendar;
import com.example.calendar.models.CalendarInput;
import com.example.calendar.models.Country;
import com.example.calendar.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CalendarMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private CalendarService calendarService;

    public Calendar createCalendar(CalendarInput calendarInput){
        Country countryObj = new Country(calendarInput.getCountryCode());
        Calendar calendarObj = new Calendar(0, calendarInput.getEvent(), calendarInput.getCategory(), LocalDate.parse(calendarInput.getHolidayDate()), countryObj);
        return this.calendarService.addCalendar(calendarObj);
    }

    public Calendar updateCalendar(long calendarId, Calendar calendar){
        return this.calendarService.updateCalendar(calendarId, calendar);
    }

    public Boolean deleteCalendar(long calendarId){
        return this.calendarService.deleteCalendarById(calendarId);
    }
}
