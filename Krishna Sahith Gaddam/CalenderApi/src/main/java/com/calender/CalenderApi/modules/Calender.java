package com.calender.CalenderApi.modules;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "Calender")
public class Calender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(hidden = true)
    @Column(name="Holiday_Id")
	private long holidayId;
    @Column(name="Event",length = 50,nullable = false)
	private String event;
    @Column(name="Category",length = 25,nullable = false)
	private String category;
    @Column(name="Holiday_Date")
    private LocalDate holiday;
    @Column(name="Country_code")
    private long country_code;


	

}
