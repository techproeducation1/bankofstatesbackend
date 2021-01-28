package com.bank.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.dao.AccountDAO;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.model.User;
import com.bank.service.AccountService;
import com.bank.service.TransactionService;
import com.bank.util.TransactionType;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private TransactionService transactionService;

	@Override
	public Account createAccount() {
		Account account = new Account();
		account.setAccountBalance(new BigDecimal(0.0));
		account.setAccountNumber(getAccountNumber());
		accountDAO.save(account);
		return accountDAO.findByAccountNumber(account.getAccountNumber());
	}

	@Override
	public void deposit(double amount, User user) {
		Account account = user.getAccount();
		account.setAccountBalance(account.getAccountBalance().add(new BigDecimal(amount)));
		accountDAO.save(account);
		Date date = new Date();
		Transaction transaction = new Transaction(date, "Self Deposit", TransactionType.DEPOSIT.toString(), amount,
				account.getAccountBalance(), account);
		transactionService.saveTransaction(transaction);
	}

	@Override
	public void withdraw(double amount, User user) {
		Account account = user.getAccount();
		account.setAccountBalance(account.getAccountBalance().subtract(new BigDecimal(amount)));
		accountDAO.save(account);
		Date date = new Date();
		Transaction transaction = new Transaction(date, "Self Withdrawal", TransactionType.WITHDRAW.toString(), amount,
				account.getAccountBalance(), account);
		transactionService.saveTransaction(transaction);
	}

	private Long getAccountNumber() {
		long smallest = 1000_0000_0000_0000L;
		long biggest = 9999_9999_9999_9999L;
		long random = ThreadLocalRandom.current().nextLong(smallest, biggest);
		return random;
	}
}
