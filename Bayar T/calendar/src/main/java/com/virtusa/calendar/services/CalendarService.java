package com.virtusa.calendar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.virtusa.calendar.models.Calendar;
import com.virtusa.calendar.repositories.CalendarRepo;

@Service
public class CalendarService {
	
	@Autowired
	private CalendarRepo calendarRepo;
	
	public Calendar addHoliday(Calendar calendar) {
		return this.calendarRepo.save(calendar);
	}
	
	@Cacheable(value="Calendar")
	public List<Calendar> getAllHolidays() {
		return this.calendarRepo.findAll();
	}
	
	@Cacheable(value="Calendar", key="#holidayId")
	public Calendar getHolidayById(long holidayId) {
		return this.calendarRepo.findById(holidayId).orElse(null);
	}
	
	@CacheEvict(value="Calendar", key="#holidayId")
	public boolean deleteHolidayById(long holidayId) {
		boolean status = false;
		this.calendarRepo.deleteById(holidayId);
		if(this.getHolidayById(holidayId) == null) {
			status = true;
		}
		return status;
	}
	
	@CachePut(value="Calendar", key="#holidayId")
	public Calendar updateHoliday(long holidayId, String event) {
		Calendar calendar = this.getHolidayById(holidayId);
		if(calendar != null) {
			calendar.setEvent(event);
		}
		return this.calendarRepo.save(calendar);
	}

}
