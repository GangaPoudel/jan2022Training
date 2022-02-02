package com.example.calendar.repositories;

import com.example.calendar.models.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarRepo extends JpaRepository<Calendar, Long> {

}
