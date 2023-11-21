package com.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.InvalidIdException;

import com.demo.model.BankExecutive;
import com.demo.repository.BankExecutiveRepository;

@Service
public class BankExecutiveService {
	
	@Autowired
	private BankExecutiveRepository bankExecutiveRepository;

	public BankExecutive insert(BankExecutive bankExecutive) {
		
		return bankExecutiveRepository.save(bankExecutive);
	}

	public BankExecutive getById(int beid) throws InvalidIdException {
		Optional<BankExecutive> optional= bankExecutiveRepository.findById(beid);
		if(!optional.isPresent())
			throw new InvalidIdException("BEid invalid");
		return optional.get();
	}

}
