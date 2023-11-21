package com.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.InvalidIdException;
import com.demo.model.Account;
import com.demo.model.AccountDetails;
import com.demo.model.AccountHolder;
import com.demo.model.BankExecutive;
import com.demo.service.AccountDetailsService;
import com.demo.service.AccountHolderService;
import com.demo.service.AccountService;
import com.demo.service.BankExecutiveService;


@RestController
public class AccountDetailsController {
	
	@Autowired
	private AccountHolderService accountHolderService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private BankExecutiveService bankExecutiveService;
	
	@Autowired
	private AccountDetailsService accountDetailsService;
	
	@PostMapping("/AD/add/{ahid}/{aid}/{beid}")
	public ResponseEntity<?> assignProject(@PathVariable("ahid") int ahid,@PathVariable("aid")int aid,@PathVariable("beid")int beid,
			                                @RequestBody AccountDetails accountDetails){
			                                            
		
		try {
			
			//step-1:
			  AccountHolder accountHolder = accountHolderService.getById(ahid);
			  
			  //step-2:
			  Account account = accountService.getById(aid);
			  
			  BankExecutive bankExecutive = bankExecutiveService.getById(beid);
			  
			  //step-3:
		    accountDetails.setAccount(account);
		    
		    accountDetails.setAccountHolder(accountHolder);
		    
		    accountDetails.setBankExecutive(bankExecutive);
		    
		    accountDetails.setDateOfCreation(LocalDate.now());
			  
			  
			  //step:4
			  accountDetails=accountDetailsService.insert(accountDetails);
			  return ResponseEntity.ok().body(accountDetails);
					  
		}catch(InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
	

