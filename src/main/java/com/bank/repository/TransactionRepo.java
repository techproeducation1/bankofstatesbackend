package com.bank.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bank.model.Transaction;

public interface TransactionRepo extends CrudRepository<Transaction, Long> {

	@Query("select tr from Transaction tr where tr.account.id= :accountId and tr.date >= :date order by tr.date")
	List<Transaction> getTransactionByAccountAndDate(@Param("accountId") Long accountId, @Param("date") Date date);

	@Query("select tr from Transaction tr where tr.date >= :date order by tr.date")
	List<Transaction> getTransactionByDate(@Param("date") Date date);
}
