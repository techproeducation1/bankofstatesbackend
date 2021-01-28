package com.bank.service;

import com.bank.model.Account;
import com.bank.model.User;

public interface AccountService {

	Account createAccount();

	void deposit(double amount, User user);

	void withdraw(double amount, User user);

}
