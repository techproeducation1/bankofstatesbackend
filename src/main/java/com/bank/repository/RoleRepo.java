package com.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.bank.model.Role;

public interface RoleRepo extends CrudRepository<Role, Integer> {

	Role findByName(String name);

}
