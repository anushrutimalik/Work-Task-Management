package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ApiException;
import com.example.demo.models.Employee;
import com.example.demo.models.Work;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.WorkRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class WorkServices {

	@Autowired
	private WorkRepository workRepository;
	@Autowired
	private EmployeeRepository employeeRepository; //why and why not the same in employee services
	
	public Work updateWork(Work toUpdate) {
		Work existingWork = workRepository.findById(toUpdate.getWorkId()).orElseThrow(()->new ApiException("Work Not Found"));
		existingWork.setDescription(toUpdate.getDescription());
		existingWork.setTitle(toUpdate.getTitle());
		return workRepository.save(existingWork);
	}

	public Work findWork(String id) {
		return workRepository.findById(id).orElseThrow(()->new ApiException("Work Not Found"));
	}

	public Work createWork(Work data) {
		data.setCreatedOn(LocalDateTime.now());
		data.setStatus("NEW");
		return workRepository.save(data);
	}

	public List<Work> findWorks() {
		return workRepository.findAll();
	}
	
	public Work deleteWork(String id) {
		Optional<Work> exist = workRepository.findById(id);
	     if(!exist.isPresent()) {
	    	 throw new ApiException("WORK NOT FOUND");
	     }
	     else {
		     workRepository.deleteById(id);
		     return exist.get();
	     }
	}

	public Employee workAssignment(String workId, String empId) {
		Employee employee = employeeRepository.findById(empId).orElseThrow(()->new ApiException("Employee Not Found"));
		Work work = workRepository.findById(workId).orElseThrow(()->new ApiException("Work Not Found"));
		work.setStatus("ASSIGNED");
		employee.addWork(work);
		return employeeRepository.save(employee);
	}
	
	public Work acceptWork(String workId, String empId) {
	    employeeRepository.findById(empId).orElseThrow(()->new ApiException("Employee Not Found"));
		Work work = workRepository.findById(workId).orElseThrow(()->new ApiException("Work Not Found"));
		if (work.getEmployee() != null && work.getEmployee().getId().equals(empId) && work.getStatus().equals("ASSIGNED")) {
			work.setStartedOn(LocalDateTime.now());
			work.setStatus("IN PROGRESS");
			return workRepository.save(work);
		}
		else {
			throw new ApiException("This work is not pertained to requested employee");
		}
	}
	
	public Work closedWork(String workId, String empId) {
	    employeeRepository.findById(empId).orElseThrow(()->new ApiException("Employee Not Found"));
		Work work = workRepository.findById(workId).orElseThrow(()->new ApiException("Work Not Found"));
		if (work.getEmployee() != null && work.getEmployee().getId().equals(empId) && work.getStatus().equals("IN PROGRESS")) {
			work.setClosedOn(LocalDateTime.now());
			work.setStatus("CLOSE");
			return workRepository.save(work);
		}
		else {
			throw new ApiException("This work is not pertained to requested employee");
		}
	}
	
	
}
