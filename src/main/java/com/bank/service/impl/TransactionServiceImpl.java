package com.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.TrasactionDAO;
import com.bank.model.Transaction;
import com.bank.service.TransactionService;

@Service
public class TransactionServiceImpl  implements TransactionService {

	@Autowired
	TrasactionDAO transactionDAO;
	
	@Override
	public void saveTransaction(Transaction transaction) {
		transactionDAO.save(transaction);		
	}
}
