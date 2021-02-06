package com.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.bank.model.Recipient;

public interface RecipientRepo extends CrudRepository<Recipient, Long> {

}
