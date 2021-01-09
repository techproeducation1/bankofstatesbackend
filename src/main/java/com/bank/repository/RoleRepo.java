package com.bank.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bank.model.Role;

public interface RoleRepo extends CrudRepository<Role, Integer> {

	Optional<Role> findByName(String name);

}
