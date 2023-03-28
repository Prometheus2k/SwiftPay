package com.stackroute.com.BankService.controller;

<<<<<<< HEAD
=======
import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.Field;
import com.prowidesoftware.swift.model.SwiftBlock;
import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
>>>>>>> 2402b8b02f964a4d9f83417de9baab5504ab6d40
import com.stackroute.com.BankService.exceptions.CustomException;
import com.stackroute.com.BankService.model.AccountModel;
import com.stackroute.com.BankService.model.BankModel;
import com.stackroute.com.BankService.interservice.InterService;
import com.stackroute.com.BankService.model.TransactionModel;
import com.stackroute.com.BankService.model.User;
import com.stackroute.com.BankService.service.AccountServiceInterface;
import com.stackroute.com.BankService.service.BankServiceInterface;

import com.stackroute.com.BankService.service.TransactionServiceInterface;
import com.stackroute.com.BankService.swift.SwiftOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
import java.io.IOException;
import java.util.List;
import java.util.Map;

=======
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.transaction.Transaction;
>>>>>>> 2402b8b02f964a4d9f83417de9baab5504ab6d40

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("bank-service")
public class Controller {
    /*
     * Function to check whether the endpoint is working.
     */

    @GetMapping("/bank")
    public ResponseEntity<?> home() {
        ResponseEntity<?> entity = new ResponseEntity<>("Welcome to bank service", HttpStatus.OK);
        return entity;
    }

    /*
     * For Bank Model
     */

    @Autowired
    private BankServiceInterface bankService;

    @Autowired
    private AccountServiceInterface accountService;

    @Autowired
    private TransactionServiceInterface transactionService;

    @Autowired
    private InterService interService;

    @Autowired
    private SwiftOperation swiftOperation;

    @PostMapping("/bank/add")
    public ResponseEntity<?> addBankDetails(@RequestBody BankModel bank) {
        ResponseEntity<?> entity;
        try {
            bankService.addBankDetails(bank);
<<<<<<< HEAD
            entity = new ResponseEntity<>("Bank details added successfully", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
=======
            entity = new ResponseEntity<String>("Bank details added successfully", HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
>>>>>>> 2402b8b02f964a4d9f83417de9baab5504ab6d40
        }
        return entity;
    }

    @GetMapping("/bank/get")
    public ResponseEntity<?> getAllBanks() {
        List<BankModel> allBankList = bankService.getAllBankDetails();
        return new ResponseEntity<>(allBankList, HttpStatus.OK);
    }

    @GetMapping("/bank/get/{bankId}")
    public ResponseEntity<?> getBankById(@PathVariable("bankId") int bankId) {
        ResponseEntity<?> entity;
        try {
            BankModel bank = bankService.getBankById(bankId);
<<<<<<< HEAD
            entity = new ResponseEntity<>(bank, HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
=======
            entity = new ResponseEntity<BankModel>(bank, HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
>>>>>>> 2402b8b02f964a4d9f83417de9baab5504ab6d40
        }
        return entity;
    }

    @DeleteMapping("/bank/delete/{bankId}")
    public ResponseEntity<?> deleteBankById(@PathVariable("bankId") int bankId) {
        ResponseEntity<?> entity;
        try {
            bankService.deleteBankByBankId(bankId);
<<<<<<< HEAD
            entity = new ResponseEntity<>("Bank deleted", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
=======
            entity = new ResponseEntity<String>("Bank deleted", HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
>>>>>>> 2402b8b02f964a4d9f83417de9baab5504ab6d40
        }
        return entity;
    }

    @PutMapping("/bank/update/{bankId}")
    public ResponseEntity<?> updateBankDetails(@PathVariable("bankId") int bankId, @RequestBody BankModel bank) {
        ResponseEntity<?> entity;
        try {
            bankService.updateBankById(bankId, bank);
<<<<<<< HEAD
            entity = new ResponseEntity<>("Bank details updated successfully", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
=======
            entity = new ResponseEntity<String>("Bank details updated successfully", HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
>>>>>>> 2402b8b02f964a4d9f83417de9baab5504ab6d40
        }
        return entity;
    }

    /*
     * For Account Model
     */

    @PostMapping("/account/add/")
    public ResponseEntity<?> addAccountDetails(@RequestHeader Map<String, String> headers,
            @RequestBody AccountModel account) {
        String token = headers.get("token");
        User user = interService.getUserDetails(token);
        ResponseEntity<?> entity;
        try {
            if(user != null) {
                System.out.println("in /account/add/ " + token);
                accountService.addAccountDetails(account);
<<<<<<< HEAD
                entity = new ResponseEntity<>("Account details added successfully", HttpStatus.OK);
            }
            else {
                entity = new ResponseEntity<>("Invalid token", HttpStatus.BAD_REQUEST);
            }
        }
        catch (CustomException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
=======
                entity = new ResponseEntity<String>("Account details added successfully", HttpStatus.OK);
            } else {
                entity = new ResponseEntity<String>("Invalid token", HttpStatus.BAD_REQUEST);
            }
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
>>>>>>> 2402b8b02f964a4d9f83417de9baab5504ab6d40
        }
        return entity;
    }

    @GetMapping("/account/get/all")
    public ResponseEntity<?> getAllAccounts() {
        List<AccountModel> allUserList = accountService.viewAllAccounts();
        return new ResponseEntity<>(allUserList, HttpStatus.OK);
    }

    @GetMapping("/account/get")
    public ResponseEntity<?> getAccountByNumber(@RequestHeader Map<String, String> headers) {
        String token = headers.get("token");
        System.out.println(token);
        User user = interService.getUserDetails(token);
        ResponseEntity<?> entity;
        AccountModel account;
        try {
            if(user != null) {
                account = accountService.getAccountByUserEmailId(user.getEmailId());
                entity = new ResponseEntity<>(account, HttpStatus.OK);
            }
            else {
                entity = new ResponseEntity<>("Invalid token", HttpStatus.BAD_REQUEST);
            }

        } catch (CustomException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @DeleteMapping("/account/delete/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable("accountNumber") String accountNumber) {
        ResponseEntity<?> entity;
        try {
            accountService.deleteAccount(accountNumber);
<<<<<<< HEAD
            entity = new ResponseEntity<>("Account deleted", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
=======
            entity = new ResponseEntity<String>("Account deleted", HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
>>>>>>> 2402b8b02f964a4d9f83417de9baab5504ab6d40
        }
        return entity;
    }

    @PutMapping("/account/update/{accountNumber}")
<<<<<<< HEAD
    public ResponseEntity<?> updateAccount(@PathVariable("accountNumber") String accountNumber, @RequestBody AccountModel account) {
        ResponseEntity<?> entity;
        try {
            accountService.updateAccount(accountNumber, account);
            entity = new ResponseEntity<>("Account updated successfully", HttpStatus.OK);
        }
        catch (CustomException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
=======
    public ResponseEntity<?> updateAccount(@PathVariable("accountNumber") String accountNumber,
            @RequestBody AccountModel account) {
        ResponseEntity<?> entity = null;
        try {
            accountService.updateAccount(accountNumber, account);
            entity = new ResponseEntity<String>("Account updated successfully", HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
>>>>>>> 2402b8b02f964a4d9f83417de9baab5504ab6d40
        }
        return entity;
    }

    /*
     * To initiate transfer
     */

    @PostMapping("/transfer")
    public ResponseEntity<?> initiateTransfer(@RequestHeader Map<String, String> headers, @RequestBody TransactionModel requestModel) {
        String token = headers.get("token");
        User user = interService.getUserDetails(token);
        ResponseEntity<?> entity;
        try {
            if(user != null) {
                boolean checkSender = transactionService.verifyAccount(requestModel.getSenderAccountNumber());
                boolean checkReceiver = transactionService.verifyAccount(requestModel.getReceiverAccountNumber());
                boolean checkBalance = transactionService.checkBalance(requestModel.getSenderAccountNumber(), requestModel.getDebit());
                if(checkSender && checkReceiver && checkBalance) {
                    String MT101 = swiftOperation.generateMT101(requestModel);

                    System.out.println("----------MT101-----------");
                    System.out.println(MT101);
                    System.out.println("--------------------------");

                    transactionService.addTransactionDetails(requestModel, MT101);
                    TransactionModel transactionModel = interService.initiateTransaction(requestModel);
                    if(transactionModel.getStatus().equals("ACK")) {
                        transactionService.updateStatus(requestModel.getTransactionId(), "ACK");
                        transactionService.executeDebit(transactionModel.getMessage());
                        entity = new ResponseEntity<>("Transfer success", HttpStatus.OK);
                    }
                    else {
                        transactionService.updateStatus(requestModel.getTransactionId(), "NACK");
                        entity = new ResponseEntity<>("Transfer failed", HttpStatus.BAD_REQUEST);
                    }
                }
                else {
                    entity = new ResponseEntity<>("Invalid details", HttpStatus.BAD_REQUEST);
                }
            }
            else {
                entity = new ResponseEntity<>("Invalid token", HttpStatus.BAD_REQUEST);
            }
        }
        catch (CustomException | IOException e) {
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}