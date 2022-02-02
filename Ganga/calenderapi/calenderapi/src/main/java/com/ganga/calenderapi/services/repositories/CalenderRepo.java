package com.ganga.calenderapi.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.calenderapi.services.models.Calender;

public interface CalenderRepo extends JpaRepository<Calender,Long>{
	
	
}
