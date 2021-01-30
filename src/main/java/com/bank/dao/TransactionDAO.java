package com.bank.dao;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class TransactionDAO {
	private String date;
	private String description;
	private String type;
	private double amount;
	private BigDecimal availableBalance;
	private Boolean isTransfer;
}
