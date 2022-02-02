package com.ganga.calenderapi.services.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="Calender")
public class Calender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Calender_Id")
	private long id;
	@Column(name ="Calender_Event",length = 50,nullable = false)
	private String event;
	@Column(name ="Calender_Date")
	private LocalDate date;
	

}
