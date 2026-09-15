package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ApiException;
import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServices {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee emp) {
		 emp.setStatus("RECEIVED");
	     return employeeRepository.save(emp);
	}
	public Employee deleteEmployee(String id) {
		 Optional<Employee> exist = employeeRepository.findById(id);
	     if(!exist.isPresent()) {
	    	 throw new ApiException("Employee NOT FOUND");
	     }
	     else {
		     employeeRepository.deleteById(id);
		     return exist.get(); //?
	     }
	}
	public Employee updateEmployee(Employee toUpdate) {
		 Employee u = employeeRepository.findById(toUpdate.getId()).orElseThrow(()->new ApiException("Employee not found"));
		 u.setFullname(toUpdate.getFullname());
	     u.setEmail(toUpdate.getEmail());
	     u.setDob(toUpdate.getDob());
	     u.setDepartment(toUpdate.getDepartment());
	     u.setDesignation(toUpdate.getDesignation());
	     return employeeRepository.save(u);
	}
	public List<Employee> findEmployees(){
		return employeeRepository.findAll();
	}
	public Employee findEmployee(String id) {
		return employeeRepository.findById(id).orElseThrow(()->new ApiException("Employee Not Found"));
	}
}

