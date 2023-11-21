package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Account;
import com.demo.model.AccountHolder;
import com.demo.service.AccountHolderService;
import com.demo.service.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountHolderService accountHolderService;
	
	@PostMapping("/Account/add")
	public  ResponseEntity<?> insertAccount(
			@RequestBody Account account){
	
		
		
		
		account = accountService.insertAccount(account);
	return ResponseEntity.ok().body(account);
}
	
	
}

	