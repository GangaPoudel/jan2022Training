package com.virtusa.calendarapi.services;

import com.virtusa.calendarapi.models.Calendar;
import com.virtusa.calendarapi.repositories.CalendarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepo calendarRepo;

//    @Cacheable(value = "Calendar")
    //list all holidays
    public List<Calendar> getAllHolidays() {
        return this.calendarRepo.findAll();
    }

//    @Cacheable(value="Calendar", key="#calendarId")
    //list holiday by id
    public Calendar getHolidayById(long holidayId) {
        return this.calendarRepo.findById(holidayId).orElse(null);
    }

    //insert
    public Calendar addHoliday(Calendar calendar) {
        return this.calendarRepo.save(calendar);
    }

//    @CachePut(value="Calendar", key="#calendarId")
    //update
    public Calendar updateHoliday(long holidayId, String category) {
        Calendar calendar=this.getHolidayById(holidayId);
        if(calendar!=null) {
            calendar.setCategory(category);
        }
        return this.calendarRepo.save(calendar);
    }

//    @CacheEvict(value="Calendar", key="#calendarId")
    //delete
    public boolean deleteHolidayById(long holidayId) {
        Calendar calendar=this.getHolidayById(holidayId);
        if(calendar!=null) {
            this.calendarRepo.deleteById(holidayId);
            return true;
        } else {
            return false;
        }
    }
}
