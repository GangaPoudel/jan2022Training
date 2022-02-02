package com.calender.CalenderApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calender.CalenderApi.modules.Calender;
import com.calender.CalenderApi.repositories.CalenderRepo;




@Service
public class CalenderServices {
	@Autowired
	private CalenderRepo calenderrepo;
	
	//insert 
	
	public Calender addCalender(Calender calender) {
		return this.calenderrepo.save(calender);
	}
	
	//list all 
	
	public List<Calender> getAllCalenders(){
		return this.calenderrepo.findAll();
	}
	
	//list by Id
	
	public Calender getHolidayById(long holidayId) {
		return this.calenderrepo.findById(holidayId).orElse(null);
	}
	
	//delete

		public boolean deleteCalenderById(long holidayId) {
			boolean status=false;
			this.calenderrepo.deleteById(holidayId);
			if(this.getHolidayById(holidayId)==null)
				status=true;
			return status;
		}
		
		//update
		
		public Calender updateCalender(long holidayId,String event) {
			
			Calender calender=this.getHolidayById(holidayId);
			if(calender!=null) {
				calender.setEvent(event);
			}
			
			return this.calenderrepo.save(calender);
		}
	

}
