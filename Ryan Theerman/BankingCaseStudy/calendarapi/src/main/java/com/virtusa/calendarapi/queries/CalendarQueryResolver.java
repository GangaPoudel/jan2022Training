package com.virtusa.calendarapi.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalendarQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private CalendarService calendarService;

    public List<Calendar> getAllHolidays() {
        return this.calendarService.getAllHolidays();
    }

    public Calendar getHolidayById(long holidayId) {
        return this.calendarService.getHolidayById(holidayId);
    }
}
