package com.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.InvalidIdException;
import com.demo.model.AccountHolder;
import com.demo.model.BankExecutive;
import com.demo.service.AccountHolderService;
import com.demo.service.BankExecutiveService;


@RestController
public class AccounHolderController {
	@Autowired
	private AccountHolderService accountHolderService;
	
	@Autowired
	private BankExecutiveService bankExecutiveService;
	
	
	@PostMapping("/AH/add")
	public  ResponseEntity<?> insertAccountHolder(
			@RequestBody AccountHolder accountHolder){
	
		
		
		
		accountHolder = accountHolderService.insertAccountHolder(accountHolder);
	return ResponseEntity.ok().body(accountHolder);

}
	@GetMapping("/getallbyexecutive/{eid}")
	public ResponseEntity<?> getAccountHoldersByBankExecutive(@PathVariable("beid") int beid) {

		try {
			BankExecutive bankExecutive = bankExecutiveService.getById(beid);
			List<AccountHolder> list = accountHolderService.getAccountHoldersByBankExecutive(beid);
			return ResponseEntity.ok().body(list);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
