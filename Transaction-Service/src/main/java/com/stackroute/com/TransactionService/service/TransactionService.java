package com.stackroute.com.TransactionService.service;

import com.stackroute.com.TransactionService.exceptions.CustomException;
import com.stackroute.com.TransactionService.model.TransactionModel;
import com.stackroute.com.TransactionService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService implements TransactionServiceInterface{
	@Autowired
	private TransactionRepository repository;

	@Override
	public void addTransactions(TransactionModel transaction) throws CustomException {
		Optional<TransactionModel> optional = repository.findByAccountNumber(transaction.getAccountNumber());
		 if(optional.isPresent()){
			throw new CustomException("Transaction data already Exists");
			}
		repository.save(transaction);

	}

	@Override
	public List<TransactionModel> getAllTransactions() {
		return repository.findAll();
	}
}
