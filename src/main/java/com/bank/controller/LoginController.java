package com.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@GetMapping("/")
    public String home() {
        return ("<h1>Home Page</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>User Page</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Admin Page</h1>");
    }

}
