package com.ganga.customerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganga.customerapi.models.Department;
import com.ganga.customerapi.repositories.DepartmentRepo;


@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo deptRepo;

	// insert

	public Department addDepartment(Department department) {
		return this.deptRepo.save(department);
	}

	// list all the departments

	public List<Department> getAllDepartment() {
		return this.deptRepo.findAll();
	}

	// list bank by Id

	public Department getDepartmentById(long id) {
		return this.deptRepo.findById(id).orElse(null);
	}

	// delete

	public boolean deleteDepartmentById(long id) {
		boolean status = false;
		this.deptRepo.deleteById(id);
		if (this.getDepartmentById(id) == null)
			status = true;
		return status;
	}

	// update


	public Department updateDepartment(long id, String address) {

		Department department = this.getDepartmentById(id);
		if (department != null) {
			department.setAddress(address);
		}

		return this.deptRepo.save(department);
	}
}
