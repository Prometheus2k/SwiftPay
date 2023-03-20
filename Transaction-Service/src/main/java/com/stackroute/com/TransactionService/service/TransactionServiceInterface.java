package com.stackroute.com.TransactionService.service;

import com.stackroute.com.TransactionService.exceptions.CustomException;
import com.stackroute.com.TransactionService.model.TransactionModel;

import java.util.List;

public interface TransactionServiceInterface  {

	public void addTransactions(TransactionModel transaction) throws CustomException;

	public List<TransactionModel> getAllTransactions();
}
