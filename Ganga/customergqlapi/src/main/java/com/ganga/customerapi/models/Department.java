package com.ganga.customerapi.models;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Department_Id")
	private long id;
	@Column(name = "DepartmentName", length = 50, nullable = false)
	private String name;
	@Column(name = "DepartmentAddress", length = 50, nullable = false)
	private String address;

}
