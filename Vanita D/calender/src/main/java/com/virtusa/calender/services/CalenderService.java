package com.virtusa.calender.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.virtusa.calender.models.Calender;
import com.virtusa.calender.repositories.CalenderRepository;


@Service
public class CalenderService {
	@Autowired
	private CalenderRepository cRepo;
	
	//insert 
	
	public Calender addCalender(Calender calender) {
		return this.cRepo.save(calender);
	}
	
	//list all the calender
	@Cacheable(value="Calender")
	public List<Calender> getAllCalenders(){
		return this.cRepo.findAll();
	}
	
	@Cacheable(value="Calender", key="#calenderId")
	public Calender getCalenderById(long calenderId) {
		System.out.println("caching is not used");
		return this.cRepo.findById(calenderId).orElse(null);
	}
	
	//delete
	@CacheEvict(value="Calender", key="#calenderId")
	public boolean deleteCalenderById(long calenderId) {
		boolean status=false;
		this.cRepo.deleteById(calenderId);
		if(this.getCalenderById(calenderId)==null)
			status=true;
		return status;
	}
	
	//update
	@CachePut(value="Calender", key="#calenderId")
	public Calender updateCalender(Long calenderId, String category) {
		Calender calender=this.getCalenderById(calenderId);
		if(calender!=null) {
			calender.setCategory(category);
		}
		
		return this.cRepo.save(calender);
	}
}
