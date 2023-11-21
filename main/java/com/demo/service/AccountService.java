package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.InvalidIdException;
import com.demo.model.Account;

import com.demo.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	public Account insertAccount(Account account) {
	
		return accountRepository.save(account);
	}

	public Account getById(int aid) throws InvalidIdException {
		Optional<Account> optional = accountRepository.findById(aid);
		if(!optional.isPresent())
			throw new InvalidIdException("Aid invalid");
		return optional.get();	}

}
