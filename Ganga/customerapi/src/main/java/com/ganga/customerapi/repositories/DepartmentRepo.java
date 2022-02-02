package com.ganga.customerapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganga.customerapi.models.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
