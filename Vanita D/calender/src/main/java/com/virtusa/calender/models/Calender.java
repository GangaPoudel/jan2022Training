package com.virtusa.calender.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
@Entity
@Table(name="Calender")
public class Calender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Holiday_Id")
	private long holidayId;
	
	@Column(name="Event", length = 50,nullable = false)
	private String event;
	
	@Column(name="Category", length = 50,nullable = false)
	private String category;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="DOB")
	private LocalDate holidayDate;
}