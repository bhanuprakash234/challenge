package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.InvalidIdException;
import com.demo.model.AccountHolder;
import com.demo.repository.AccountHolderRepository;


@Service
public class AccountHolderService {
	
	@Autowired
	private AccountHolderRepository accountHolderRepository;

	public AccountHolder insertAccountHolder(AccountHolder accountHolder) {
		
		return accountHolderRepository.save(accountHolder);
	}

	public AccountHolder getById(int ahid) throws InvalidIdException {
		Optional<AccountHolder> optional = accountHolderRepository.findById(ahid);
		if(!optional.isPresent())
			throw new InvalidIdException("AHid invalid");
		return optional.get();
	}
	public List<AccountHolder> getAccountHoldersByBankExecutive(int beid) {
		// TODO Auto-generated method stub
		return accountHolderRepository.getAccountHoldersByBankExecutive(beid);
	}
}

}
