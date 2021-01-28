package com.bank.request;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignUpForm {
    @NotBlank
    @Size(min = 3, max = 50)
    private String firstName;
    
    @NotBlank
    @Size(min = 3, max = 50)
    private String lastName;


    @NotBlank
    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 60)
    @Email(message="Please provide valid Email Address")
    private String email;
    
    @NotBlank
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password; 
}