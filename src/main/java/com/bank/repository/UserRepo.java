package com.bank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bank.model.User;

public interface UserRepo extends CrudRepository<User, Long> {

	User findByUsername(String username);

	User findByEmail(String email);

	List<User> findAll();
}
