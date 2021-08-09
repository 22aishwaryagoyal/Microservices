package com.fisglobal.departmentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.departmentservice.model.Department;
import com.fisglobal.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/department")
public class DepartmentController 
{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllDepartments()
	{
		List <Department> departments=departmentRepository.findAll();
		if(departments.size()>0)
		{
			return ResponseEntity.status(HttpStatus.OK).body(departments);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Records");
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable("id") Long id)
	{
		Optional<Department> optional=departmentRepository.findById(id);
		if(optional.isPresent())
		{
			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Record Found");
		}
	}
	
}
