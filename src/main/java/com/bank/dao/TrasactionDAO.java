package com.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.bank.model.Transaction;

public interface TrasactionDAO extends CrudRepository<Transaction, Long>{

}
