package com.stackroute.com.TransactionService.controller;

import com.stackroute.com.TransactionService.exceptions.CustomException;
import com.stackroute.com.TransactionService.model.AccountModel;
import com.stackroute.com.TransactionService.model.TransactionModel;
import com.stackroute.com.TransactionService.model.User;
import com.stackroute.com.TransactionService.service.AccountServiceInterface;
import com.stackroute.com.TransactionService.service.TransactionServiceInterface;
import com.stackroute.com.TransactionService.interservice.InterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("transaction-service")
public class TransactionController {




	@Autowired
	private TransactionServiceInterface transactionService;



	@Autowired
	private InterService interService;

	@Autowired
	private AccountServiceInterface accountService;


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
	public ResponseEntity<?> addTransaction(@RequestBody List<TransactionModel> transaction) {
		ResponseEntity<?> entity = null;
		try {
			transactionService.addTransactions(transaction.get(0));
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

	@GetMapping("/transactions/get")
	public ResponseEntity<?> getTransactions(@RequestHeader Map<String, String> headers  ) {
		String token = headers.get("token");
		System.out.println(token);
		User user = interService.getUserDetails(token);
		ResponseEntity<?> entity = null;
		AccountModel account = null;

		try {
			if(user != null){
				account = accountService.getAccountByUserEmailId(user.getEmailId());
				List<TransactionModel> transaction = transactionService.getTransactionsByAccountNumber(account.getAccountNumber());
				entity = new ResponseEntity<List<TransactionModel>>(transaction, HttpStatus.OK);
			}
			else {
				entity = new ResponseEntity<String>("Invalid token", HttpStatus.BAD_REQUEST);
			}
		}catch (CustomException e) {
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
