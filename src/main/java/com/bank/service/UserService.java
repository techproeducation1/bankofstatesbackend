package com.bank.service;

import java.util.List;

import com.bank.dao.UserDAO;
import com.bank.model.User;

public interface UserService {
 
	UserDAO getUserDAO(User user);
	
	UserDAO getUserDAOByName(String userName);
	
	List<UserDAO> getAllUsers();
	
}
