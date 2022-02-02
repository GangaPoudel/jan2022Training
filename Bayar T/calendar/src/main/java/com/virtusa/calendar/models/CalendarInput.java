package com.virtusa.calendar.models;

import com.virtusa.calendar.models.CalendarInput;

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
}
