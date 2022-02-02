package com.calender.CalenderApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calender.CalenderApi.modules.Calender;


public interface CalenderRepo extends JpaRepository<Calender,Long> {

}
