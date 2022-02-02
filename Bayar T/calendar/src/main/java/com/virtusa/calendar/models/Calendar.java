package com.virtusa.calendar.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Calendar")
@AllArgsConstructor
@NoArgsConstructor
public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(hidden = true)
	@Column(name = "Holiday_Id")
	private long holidayId;
	
	@Column(name="Event",length = 50, nullable = false)
	private String event;
	
	@Column(name="Category")
	private String category;
	
	//@DateTimeFormat(iso = ISO.DATE)
	@Column(name="Date_Holiday")
	private String dateHoliday;
	
}
