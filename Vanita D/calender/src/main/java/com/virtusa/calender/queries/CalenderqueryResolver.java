package com.virtusa.calender.queries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtusa.calender.models.Calender;
import com.virtusa.calender.services.CalenderService;


@Component
public class CalenderqueryResolver implements GraphQLQueryResolver {
	@Autowired
	private CalenderService cService;
	
	public List<Calender> findAllCalenders(){
		return this.cService.getAllCalenders();
	}
	
	public Calender findCalender(long holidayId) {
	
		return this.cService.getCalenderById(holidayId);
	}
}
