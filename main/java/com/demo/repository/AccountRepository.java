package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
