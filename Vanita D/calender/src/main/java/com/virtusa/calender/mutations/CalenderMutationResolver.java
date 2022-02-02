package com.virtusa.calender.mutations;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.virtusa.calender.models.Calender;
import com.virtusa.calender.models.CalenderInput;
import com.virtusa.calender.services.CalenderService;


@Component
public class CalenderMutationResolver implements GraphQLMutationResolver {
	@Autowired
	private CalenderService cService;
	public Calender createCalender(CalenderInput calenderInput) {
		return this.cService.addCalender(new Calender(0,calenderInput.getEvent(),
				calenderInput.getCategory(),LocalDate.parse(calenderInput.getHolidayDate())));
	}
	
//	public Calender updateCalender(long bankId,String category) {
//		return this.cService.updateCalender(bankId, category);
//	}
}
