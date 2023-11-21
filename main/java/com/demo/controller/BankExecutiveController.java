package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.BankExecutive;
import com.demo.model.user;
import com.demo.service.BankExecutiveService;
import com.demo.service.UserService;


@RestController
public class BankExecutiveController {
	
	@Autowired
	private BankExecutiveService bankExecutiveService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/BE/add")
	public ResponseEntity<?> insertBexecutive(
			@RequestBody BankExecutive bankExecutive) {
		
		
		user User=bankExecutive.getUser();
	
	
		
	
		
		
		User = userService.insert(User);
		
		bankExecutive.setUser(User);
		User.setRole("EXECUTIVE");
		bankExecutive= bankExecutiveService.insert(bankExecutive);
		
		return ResponseEntity.ok().body(bankExecutive);
		
		
	}
	

}
