package com.bank.service;

import java.util.List;

import com.bank.dao.RecipientDAO;
import com.bank.dao.UserDAO;
import com.bank.model.User;

public interface UserService {
 
	UserDAO getUserDAO(User user);
	
	UserDAO getUserDAOByName(String userName);
	
	List<UserDAO> getAllUsers();

	List<RecipientDAO> getRecipients(String username);
	
}
