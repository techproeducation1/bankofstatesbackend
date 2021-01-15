package com.bank.response;

import com.bank.dao.UserDAO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
	private UserDAO user;
    private String jwt; 
}