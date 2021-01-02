package com.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@GetMapping("/")
	public String home() {
		return "Hello world";
	}
	
	@GetMapping("/signIn")
	public String signIn() {
		return "Logged In ";
	}
	
	@GetMapping("/signUp")
	public String signUp() {
		return "Register here";
	}

}
