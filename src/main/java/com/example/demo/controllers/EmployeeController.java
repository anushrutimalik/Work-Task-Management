package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.EmployeeServices;

import jakarta.servlet.http.HttpSession;

import com.example.demo.dto.Response;
import com.example.demo.models.Employee;

@RestController 
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServices employeeServices;
	
	@PostMapping(value="/create")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee data, HttpSession session){
		   try {
			   if(session.getAttribute("loggedIn") != null && (boolean)session.getAttribute("loggedIn") ) {
			     return new ResponseEntity<>(employeeServices.createEmployee(data),HttpStatus.OK);
			   }else
				  return new ResponseEntity<Object>(new Response("Login First"),HttpStatus.FORBIDDEN);  
		    } catch (Exception e) {
			     return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		    }
	}
	
	@GetMapping("/readAll")
	public ResponseEntity<Object> readEmployees(){
		try {
			return new ResponseEntity<Object>(employeeServices.findEmployees(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		}
	}
	@GetMapping("/read/{id}")
	public ResponseEntity<Object> readEmployee(@PathVariable String id){
		try {
			return new ResponseEntity<Object>(employeeServices.findEmployee(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee toUpdate){
		   try {
			   return new ResponseEntity<>(employeeServices.updateEmployee(toUpdate),HttpStatus.OK);
		    } catch (Exception e) {
			     return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		    }
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String id){
		try {
			return new ResponseEntity<Object>(employeeServices.deleteEmployee(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		}
	}
}
  