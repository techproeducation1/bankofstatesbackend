package com.bank.service;

import com.bank.model.Account;
import com.bank.model.Recipient;
import com.bank.model.User;
import com.bank.request.TransactionRequest;

public interface AccountService {

	Account createAccount();

	void deposit(TransactionRequest request, User user);

	void withdraw(TransactionRequest request, User user);

	void saveRecipient(Recipient recipient);

}
