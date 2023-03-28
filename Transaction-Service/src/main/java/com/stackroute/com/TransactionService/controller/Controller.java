package com.stackroute.com.TransactionService.controller;

import com.stackroute.com.TransactionService.exceptions.CustomException;
import com.stackroute.com.TransactionService.model.TransactionModel;
import com.stackroute.com.TransactionService.service.Scheduler;
import com.stackroute.com.TransactionService.service.TransactionServiceInterface;
import com.stackroute.com.TransactionService.swift.SwiftOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("transaction-service")
public class Controller {


	@Autowired
	private TransactionServiceInterface transactionService;

	@Autowired
	private SwiftOperation swiftOperation;

	@Autowired
	private Scheduler scheduler;

	/*
	Function To test Get ALL Transaction History
	 */
	@GetMapping("/test")
	public ResponseEntity<?> home() {
		ResponseEntity<?> entity = new ResponseEntity<>("Welcome to Transaction Service", HttpStatus.OK);
		return entity;
	}

/*
Function to Add a Transaction to the history*/

	@PostMapping("/transaction/add")
	public ResponseEntity<?> addTransaction(@RequestBody List<TransactionModel> transaction) {
		ResponseEntity<?> entity = null;
		try {
			transactionService.addTransaction(transaction.get(0));
			entity = new ResponseEntity<>("Transaction added", HttpStatus.OK);


		} catch (CustomException e) {
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	/*function to Get all Transactions*/

	@GetMapping("/transaction/history")
	public ResponseEntity<?> getAllTransactions() {
		List<TransactionModel> allTransactions = transactionService.getAllTransactions();
		ResponseEntity<?> entity = new ResponseEntity<>(allTransactions, HttpStatus.OK);
		return entity;
	}

	@GetMapping("/transaction/history/{accountNumber}")
	public ResponseEntity<?> getTransactionsByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
		ResponseEntity<?> entity = null;
		try {
			List<TransactionModel> transaction = transactionService.getTransactionsByAccountNumber(accountNumber);
			entity = new ResponseEntity<>(transaction, HttpStatus.OK);
		} catch (CustomException e) {
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}

		return entity;
	}

	/*
	 * For transfer
	 */
	@PostMapping("/transfer")
	public ResponseEntity<?> initiateTransfer(TransactionModel transactionModel) {
		ResponseEntity<?> entity = null;
		try {
			boolean checkMessage = transactionService.checkMT101(transactionModel.getMessage());
			if(checkMessage) {
				transactionModel.setStatus("ACK");
				transactionService.addTransaction(transactionModel);
				String MT900 = swiftOperation.generateMT900(transactionModel.getMessage());

				System.out.println("------------MT900----------");
				System.out.println(MT900);
				System.out.println("----------------------------");

				transactionModel.setMessage(MT900);
				entity = new ResponseEntity<>(transactionModel, HttpStatus.OK);
			}
		}
		catch (CustomException | IOException e) {
			transactionModel.setStatus("NACK");
			entity = new ResponseEntity<>(transactionModel, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}


}
