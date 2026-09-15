package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Response;
import com.example.demo.dto.UserInfo;
import com.example.demo.dto.Userdto;
import com.example.demo.services.UserServices;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private UserServices userServices;
	/*
	 * @PostMapping(value="/loginProcess") public ResponseEntity<Object>
	 * loginProcess(@RequestBody UserInfo userInfo, HttpSession session){ try {
	 * if(userServices.isValidCredentials(userInfo.getEmail(),
	 * userInfo.getPassword())) { session.setAttribute("loggedIn", true);
	 * session.setAttribute("email", userInfo.getEmail()); return new
	 * ResponseEntity<>(new Response("Authenticated"),HttpStatus.OK); } else return
	 * new ResponseEntity<>(new
	 * Response("Invalid Credentials"),HttpStatus.FORBIDDEN); } catch (Exception e)
	 * { return new ResponseEntity<Object>(e,HttpStatus.EXPECTATION_FAILED); } }
	 */
	
	@PostMapping(value = "/createUser")
	public ResponseEntity<Object> createUser(@RequestBody Userdto data){
		try {
			return new ResponseEntity<Object>(userServices.createUser(data), HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(e, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
