package com.virtusa.calendarapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarInput {

    private String event;
    private String category;
    private String dateHoliday;
    private String countryCode;
}
