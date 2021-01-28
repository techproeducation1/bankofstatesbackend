package com.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.bank.model.Account;

public interface AccountDAO extends CrudRepository<Account, Long> {

	Account findByAccountNumber(Long accountNumber);
}
