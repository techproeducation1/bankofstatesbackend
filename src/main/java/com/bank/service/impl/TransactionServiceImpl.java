package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Transaction;
import com.bank.repository.TransactionRepo;
import com.bank.service.TransactionService;

@Service
public class TransactionServiceImpl  implements TransactionService {

	@Autowired
	TransactionRepo transactionRepo;
	
	@Override
	public void saveTransaction(Transaction transaction) {
		transactionRepo.save(transaction);		
	}
}
