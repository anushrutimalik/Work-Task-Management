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

import com.example.demo.models.Work;
import com.example.demo.services.WorkServices;

@RestController
@RequestMapping("/work")
public class WorkController {
	
	@Autowired
	private WorkServices workServices;

	@PostMapping(value="/create")
	public ResponseEntity<Object> createEmployye(@RequestBody Work data){
		   try {
			     return new ResponseEntity<>(workServices.createWork(data),HttpStatus.OK);
		    } catch (Exception e) {
			     return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		    }
	}
	@GetMapping("/readAll")
	public ResponseEntity<Object> readEmployees(){
		try {
			return new ResponseEntity<Object>(workServices.findWorks(),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		}
	}
	@GetMapping("/read/{id}")
	public ResponseEntity<Object> readEmployee(@PathVariable String id){
		try {
			return new ResponseEntity<Object>(workServices.findWork(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping(value="/update/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Work toUpdate){
		   try {
			   return new ResponseEntity<>(workServices.updateWork(toUpdate),HttpStatus.OK);
		    } catch (Exception e) {
			     return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		    }
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> deleteWork(@PathVariable String id){
		try {
			return new ResponseEntity<>(workServices.deleteWork(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping(value="/work-assignment/{workId}/{empId}")
	public ResponseEntity<Object> workAssignment(@PathVariable String workId,@PathVariable String empId){
		   try {
			   return new ResponseEntity<>(workServices.workAssignment(workId,empId),HttpStatus.OK);
		    } catch (Exception e) {
			     return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED);
		    }
	}
	
	@PostMapping(value="/accept-work/{workId}/{empId}")
	public ResponseEntity<Object> acceptWork(@PathVariable String workId, @PathVariable String empId){
		try {
			return new ResponseEntity<>(workServices.acceptWork(workId, empId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PostMapping(value="/closed-work/{workId}/{empId}")
	public ResponseEntity<Object> closedWork(@PathVariable String workId, @PathVariable String empId){
		try {
			return new ResponseEntity<Object>(workServices.closedWork(workId, empId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
