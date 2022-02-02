package com.virtusa.calender.models;







import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalenderInput {
	private String event;
	private String category;
	private String holidayDate;
}
