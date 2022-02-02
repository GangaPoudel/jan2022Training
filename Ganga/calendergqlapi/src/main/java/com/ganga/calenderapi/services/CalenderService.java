package com.ganga.calenderapi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.calenderapi.services.models.Calender;
import com.ganga.calenderapi.services.repositories.CalenderRepo;

@Service
public class CalenderService {

	@Autowired
	private CalenderRepo calRepo;

	// insert

	public Calender addCalender(Calender calender) {
		return this.calRepo.save(calender);
	}

	// list all the calender

	public List<Calender> getAllCalenders() {
		return this.calRepo.findAll();
	}

	// list bank by Id

	public Calender getCalenderById(long id) {
		return this.calRepo.findById(id).orElse(null);
	}

	// delete

	public boolean deleteCalenderById(long id) {
		boolean status = false;
		this.calRepo.deleteById(id);
		if (this.getCalenderById(id) == null)
			status = true;
		return status;
	}

	// update

	public Calender updateCalender(long id, String event) {

		Calender calender = this.getCalenderById(id);
		if (calender != null) {
			calender.setEvent(event);
		}

		return this.calRepo.save(calender);
	}

}
