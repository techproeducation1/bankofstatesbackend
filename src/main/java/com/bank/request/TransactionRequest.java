package com.bank.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TransactionRequest {

	@NotBlank
    private Double amount;

    @NotBlank 
    private String comment;
}
