package com.bank.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RecipientForm {
	@NotBlank
	@Size(min = 3, max = 100)
	private String name;
	@NotBlank
	@Size(min = 3, max = 50)
	private String email;
	@NotBlank
	@Size(min = 3, max = 15)
	private Integer phone;
	@NotBlank
	@Size(min = 3, max = 50)
	private String bankName;
	@NotBlank
	@Size(min = 3, max = 20)
	private String bankNumber;
}
