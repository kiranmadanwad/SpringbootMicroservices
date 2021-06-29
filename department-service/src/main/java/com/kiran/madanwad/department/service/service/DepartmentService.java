package com.kiran.madanwad.department.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kiran.madanwad.department.service.entity.Department;
import com.kiran.madanwad.department.service.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartmentService(Department department) {
		log.info("inside saveDepartment Service");
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		log.info("inside findDepartmentById Service");
		return departmentRepository.findByDepartmentId(departmentId);
	}
	
}
