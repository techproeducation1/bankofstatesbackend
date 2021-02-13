package com.bank.response;

import java.util.List;

import com.bank.dao.RecipientDAO;

import lombok.Data;

@Data
public class RecipientResponse {
	boolean isSuccess;
	String message;
	List<RecipientDAO> recipients;
}
