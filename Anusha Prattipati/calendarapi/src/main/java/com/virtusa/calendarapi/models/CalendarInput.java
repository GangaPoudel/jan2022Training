package com.virtusa.calendarapi.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarInput {
	
	private String calendarCategory;
	private String calendarEvent;
	private String dateHoliday;
	private String calendarCountrycode;

}
