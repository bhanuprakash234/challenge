package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.AccountDetails;
import com.demo.model.AccountHolder;
import com.demo.repository.AccountDetailsRepository;

@Service
public class AccountDetailsService {
	
	@Autowired
	private AccountDetailsRepository accountDetailsRepository;

	public AccountDetails insert(AccountDetails accountDetails) {
		
		return accountDetailsRepository.save(accountDetails);
	}


}
