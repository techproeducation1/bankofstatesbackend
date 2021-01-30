package com.bank.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;
	private String description;
	private String type;
	private double amount;
	private BigDecimal availableBalance;
	private Boolean isTransfer;
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	public Transaction() {

	}

	public Transaction(Date date, String description, String type, double amount, BigDecimal availableBalance,
			Boolean isTransfer , Account account) {
		super();
		this.date = date;
		this.description = description;
		this.type = type;
		this.amount = amount;
		this.availableBalance = availableBalance;
		this.isTransfer = isTransfer;
		this.account = account;
	}

}
