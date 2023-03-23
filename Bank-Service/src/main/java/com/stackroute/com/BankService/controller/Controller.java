package com.stackroute.com.BankService.controller;

import com.stackroute.com.BankService.exceptions.CustomException;
import com.stackroute.com.BankService.model.AccountModel;
import com.stackroute.com.BankService.model.BankModel;
import com.stackroute.com.BankService.model.TransactionModel;
import com.stackroute.com.BankService.service.AccountServiceInterface;
import com.stackroute.com.BankService.service.BankServiceInterface;
import com.stackroute.com.BankService.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bank-service")
public class Controller {
    /*
    * Function to check whether the endpoint is working.
    */

    @GetMapping("/bank")
    public ResponseEntity<?> home() {
        ResponseEntity<?> entity = new ResponseEntity<String>("Welcome to bank service", HttpStatus.OK);
        return entity;
    }

    /*
    * For Bank Model
    */

    @Autowired
    private BankServiceInterface bankService;

    @PostMapping("/bank/add")
    public ResponseEntity<?> addBankDetails(@RequestBody BankModel bank) {
        ResponseEntity<?> entity = null;
        try {
            bankService.addBankDetails(bank);
            entity = new ResponseEntity<String>("Bank details added successfully", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }

    @GetMapping("/bank/get")
    public ResponseEntity<?> getAllBanks() {
        List<BankModel> allBankList = bankService.getAllBankDetails();
        ResponseEntity<?> entity = new ResponseEntity<List<BankModel>>(allBankList, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/bank/get/{bankId}")
    public ResponseEntity<?> getBankById(@PathVariable("bankId") int bankId) {
        ResponseEntity<?> entity = null;
        try {
            BankModel bank = bankService.getBankById(bankId);
            entity = new ResponseEntity<BankModel>(bank, HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @DeleteMapping("/bank/delete/{bankId}")
    public ResponseEntity<?> deleteBankById(@PathVariable("bankId") int bankId) {
        ResponseEntity<?> entity = null;
        try {
            bankService.deleteBankByBankId(bankId);
            entity = new ResponseEntity<String>("Bank deleted", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }

    @PutMapping("/bank/update/{bankId}")
    public ResponseEntity<?> updateBankDetails(@PathVariable("bankId") int bankId, @RequestBody BankModel bank) {
        ResponseEntity<?> entity = null;
        try {
            bankService.updateBankById(bankId, bank);
            entity = new ResponseEntity<String>("Bank details updated successfully", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }

    /*
    * For Account Model
    */

    @Autowired
    private AccountServiceInterface accountService;

    @PostMapping("/account/add")
    public ResponseEntity<?> addAccountDetails(@RequestBody AccountModel account) {
        ResponseEntity<?> entity = null;
        try {
            accountService.addAccountDetails(account);
            entity = new ResponseEntity<String>("Account details added successfully", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }

    @GetMapping("/account/get")
    public ResponseEntity<?> getAllAccounts() {
        List<AccountModel> allUserList = accountService.viewAllAccounts();
        ResponseEntity<?> entity = new ResponseEntity<List<AccountModel>>(allUserList, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/account/get/{accountNumber}")
    public ResponseEntity<?> getAccountByNumber(@PathVariable("accountNumber") String accountNumber) {
        ResponseEntity<?> entity = null;
        try {
            AccountModel account = accountService.getAccount(accountNumber);
            entity = new ResponseEntity<AccountModel>(account, HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }

    @DeleteMapping("/account/delete/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable("accountNumber") String accountNumber) {
        ResponseEntity<?> entity = null;
        try {
            accountService.deleteAccount(accountNumber);
            entity = new ResponseEntity<String>("Account deleted", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }

    @PutMapping("/account/update/{accountNumber}")
    public ResponseEntity<?> updateAccount(@PathVariable("accountNumber") String accountNumber, @RequestBody AccountModel account) {
        ResponseEntity<?> entity = null;
        try {
            accountService.updateAccount(accountNumber, account);
            entity = new ResponseEntity<String>("Account updated successfully", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransactionModel model) {
        ResponseEntity<?> entity = null;
        try {
            transactionService.performTransaction(model);
            entity = new ResponseEntity<String>("Transfer Successful", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }
}