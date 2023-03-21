package com.stackroute.com.TransactionService.controller;

import com.stackroute.com.TransactionService.exceptions.CustomException;
import com.stackroute.com.TransactionService.model.TransactionModel;
import com.stackroute.com.TransactionService.service.TransactionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("transaction-service")
public class TransactionController {


	@Autowired
	private TransactionServiceInterface transactionService;

	/*
	Function To test Get ALL Transaction History
	 */
	@GetMapping("/test")
	public ResponseEntity<?> home() {
		ResponseEntity<?> entity = new ResponseEntity<String>("Welcome to Transaction Service", HttpStatus.OK);
		return entity;
	}

/*
Function to Add a Transaction to the history*/

	@PostMapping("/transaction/add")
	public ResponseEntity<?> addTransaction(@RequestBody TransactionModel transaction) {
		ResponseEntity<?> entity = null;
		try {
			transactionService.addTransactions(transaction);
			entity = new ResponseEntity<String>("Transaction added", HttpStatus.OK);


		} catch (CustomException e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	/*function to Get all Transactions*/

	@GetMapping("/transaction/history")
	public ResponseEntity<?> getAllTransactions() {
		List<TransactionModel> allTransactions = transactionService.getAllTransactions();
		ResponseEntity<?> entity = new ResponseEntity<List<TransactionModel>>(allTransactions, HttpStatus.OK);
		return entity;
	}

	@GetMapping("/transaction/history/{accountNumber}")
	public ResponseEntity<?> getTransactionsByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
		ResponseEntity<?> entity = null;
		try {
			List<TransactionModel> transaction = transactionService.getTransactionsByAccountNumber(accountNumber);
			entity = new ResponseEntity<List<TransactionModel>>(transaction, HttpStatus.OK);
		} catch (CustomException e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}

		return entity;
	}
}
