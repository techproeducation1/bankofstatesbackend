package com.bank.response;

import java.util.List;

import com.bank.dao.UserDAO;

import lombok.Data;

@Data
public class UserResponse {
	List<UserDAO> users;
}
