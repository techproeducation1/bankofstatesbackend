package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.User;
import com.bank.response.Response;
import com.bank.service.AccountService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@PostMapping("/deposit")
	public ResponseEntity<Response> deposit(double amount) {
		Response response = new Response();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		accountService.deposit(amount, user);	
		response.setMessage("Amount successfully deposited");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/withdraw")
	public ResponseEntity<Response> withdraw(double amount) {
		Response response = new Response();
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		accountService.withdraw(amount, user);	
		response.setMessage("Amount successfully withdrawed");
		response.setSuccess(true);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
