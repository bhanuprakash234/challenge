package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.user;

public interface UserRepository extends JpaRepository<user, Integer>{

}
