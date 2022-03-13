package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Inside saveDepartment method of DepartmentService");
		return departmentRepository.save(department);
	}

	public Optional<Department> findDepartmentById(Long id) {
		log.info("Inside findDepartmentById method of DepartmentService");
		return departmentRepository.findById(id);
	}
}
