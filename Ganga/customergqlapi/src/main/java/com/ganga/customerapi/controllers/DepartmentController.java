package com.ganga.customerapi.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganga.customerapi.models.Department;
import com.ganga.customerapi.services.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentservice;
	
	//post
	@PostMapping(value="/",params = "version=1.0")
	public ResponseEntity<?> addDepartment(@RequestBody Department department){
		Department departmentObj=this.departmentservice.addDepartment(department);
		if(departmentObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department Not Created");
		
	}
	
	//get
	@GetMapping(value="/",params = "version=1.0")
	public List<Department> getAllDepartment(){
		return this.departmentservice.getAllDepartment();
	}
	
	//get with id
	

	
	
	//put
	
	@PutMapping(value="/{id}/{address}",params = "version=1.0")
	public ResponseEntity<?> updateDepartment(@PathVariable("id") long id,@PathVariable("address") String address){
		Department departmentObj=this.departmentservice.updateDepartment(id,address);
		if(departmentObj!=null)
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentObj);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department Not Created");
		
	}
	
	
	//delete
	
	@DeleteMapping(value="/{id}",params = "version=1.0")
	public ResponseEntity<?> deleteDepartmentById(@PathVariable("id") long id){
	
		if(this.departmentservice.deleteDepartmentById(id))
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Department with "+id+"Deleted");
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Department Not Found");
		
	}

}
