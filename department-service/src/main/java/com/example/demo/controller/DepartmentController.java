package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside saveDepartment method of Department Controller");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Optional<Department> findDepartmentById(@PathVariable("id") Long id) {
		log.info("Inside findDepartmentById method of Department Controller");
		return departmentService.findDepartmentById(id);
	}
}
