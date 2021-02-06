package com.bank.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TransferRequest {

	@NotBlank
	private String recipientName;

	@NotBlank
	private Double amount;
}
