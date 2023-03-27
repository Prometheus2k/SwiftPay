package com.stackroute.com.BankService.controller;

import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.Field;
import com.prowidesoftware.swift.model.SwiftBlock;
import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.stackroute.com.BankService.exceptions.CustomException;
import com.stackroute.com.BankService.model.AccountModel;
import com.stackroute.com.BankService.model.BankModel;
import com.stackroute.com.BankService.interservice.InterService;
import com.stackroute.com.BankService.model.User;
import com.stackroute.com.BankService.service.AccountServiceInterface;
import com.stackroute.com.BankService.service.BankServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.transaction.Transaction;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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

    @Autowired
    private AccountServiceInterface accountService;

    // @Autowired
    // private TransactionServiceInterface transactionService;

    @Autowired
    private InterService interService;

    @PostMapping("/bank/add")
    public ResponseEntity<?> addBankDetails(@RequestBody BankModel bank) {
        ResponseEntity<?> entity = null;
        try {
            bankService.addBankDetails(bank);
            entity = new ResponseEntity<String>("Bank details added successfully", HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
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
        } catch (CustomException e) {
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
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @PutMapping("/bank/update/{bankId}")
    public ResponseEntity<?> updateBankDetails(@PathVariable("bankId") int bankId, @RequestBody BankModel bank) {
        ResponseEntity<?> entity = null;
        try {
            bankService.updateBankById(bankId, bank);
            entity = new ResponseEntity<String>("Bank details updated successfully", HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
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
        ResponseEntity<?> entity = null;
        try {
            if(user != null) {
                System.out.println("in /account/add/ " + token);
                accountService.addAccountDetails(account);
                entity = new ResponseEntity<String>("Account details added successfully", HttpStatus.OK);
            } else {
                entity = new ResponseEntity<String>("Invalid token", HttpStatus.BAD_REQUEST);
            }
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @GetMapping("/account/get/all")
    public ResponseEntity<?> getAllAccounts() {
        List<AccountModel> allUserList = accountService.viewAllAccounts();
        ResponseEntity<?> entity = new ResponseEntity<List<AccountModel>>(allUserList, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/account/get")
    public ResponseEntity<?> getAccountByNumber(@RequestHeader Map<String, String> headers) {
        String token = headers.get("token");
        System.out.println(token);
        User user = interService.getUserDetails(token);
        ResponseEntity<?> entity = null;
        AccountModel account = null;
        try {
            if(user != null) {
                account = accountService.getAccountByUserEmailId(user.getEmailId());
                entity = new ResponseEntity<AccountModel>(account, HttpStatus.OK);
            }
            else {
                entity = new ResponseEntity<String>("Invalid token", HttpStatus.BAD_REQUEST);
            }

        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @DeleteMapping("/account/delete/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable("accountNumber") String accountNumber) {
        ResponseEntity<?> entity = null;
        try {
            accountService.deleteAccount(accountNumber);
            entity = new ResponseEntity<String>("Account deleted", HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @PutMapping("/account/update/{accountNumber}")
    public ResponseEntity<?> updateAccount(@PathVariable("accountNumber") String accountNumber,
            @RequestBody AccountModel account) {
        ResponseEntity<?> entity = null;
        try {
            accountService.updateAccount(accountNumber, account);
            entity = new ResponseEntity<String>("Account updated successfully", HttpStatus.OK);
        } catch (CustomException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    /*
     * To initiate transfer
     */

    // @PostMapping("/transfer")
    // public ResponseEntity<?> initiateTransfer(@RequestHeader Map<String, String>
    // headers, @RequestBody TransactionModel model) {
    // String token = headers.get("token");
    // ResponseEntity<?> entity = null;
    // try {
    // if(interService.verifyUser(token)) {
    // boolean checkSender =
    // transactionService.verifyAccount(model.getSenderAccountNumber().getAccountNumber());
    // boolean checkReceiver =
    // transactionService.verifyAccount(model.getReceiverAccountNumber());
    // if(checkSender && checkReceiver) {
    // String MT101 = generateMT101(model);
    // System.out.println(MT101);
    // if(interService.initiateTransaction(MT101)) {
    // entity = new ResponseEntity<String>("Transfer success", HttpStatus.OK);
    // }
    // else {
    // entity = new ResponseEntity<String>("Transfer failed",
    // HttpStatus.BAD_REQUEST);
    // }
    // }
    // else {
    // entity = new ResponseEntity<String>("Invalid details",
    // HttpStatus.BAD_REQUEST);
    // }
    // }
    // else {
    // entity = new ResponseEntity<String>("Invalid token", HttpStatus.BAD_REQUEST);
    // }
    // }
    // catch (CustomException e) {
    // entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    // }
    // return entity;
    // }

    // private String generateMT101(TransactionModel model) {
    //     MT101 mt101 = new MT101();
    //     mt101.setSender(model.getSenderAccountNumber().getAccountNumber());
    //     mt101.setReceiver(model.getReceiverAccountNumber());
    //     mt101.addField(new Field20(generateRandom("MT101")));
    //     mt101.addField(new Field28D("1/1"));
    //     mt101.addField(new Field30(gererateDate()));
    //     mt101.addField(new Field21(generateRandom("")));
    //     Field32B field32B = new Field32B();
    //     field32B.setCurrency("USD");
    //     field32B.setAmount(model.getDebit());
    //     mt101.addField(field32B);
    //     Field50F field50F = new Field50F();
    //     field50F.setNameAndAddress1(model.getSenderLocation());
    //     mt101.addField(field50F);
    //     mt101.addField(new Field52A(generateRandom("")));
    //     Field59F field59F = new Field59F();
    //     field59F.setNameAndAddress1(model.getReceiverLocation());
    //     mt101.addField(new Field71A("SHA"));
    //     return mt101.message();
    // }
    // mt101.addField(new Field20(generateRandom("MT101")));
    // //
    // private String generateMT103(TransactionModel model) {
    //     Random random = new Random();
    //     int randomNumber = random.nextInt(9000) + 1000;
    //     int randomNumber2 = random.nextInt(900000) + 100000;
    //     MT103 mt103 = new MT103();

    //     SwiftBlock1 b1 = new SwiftBlock1();
    //     b1.setApplicationId("F");
    //     b1.setServiceId("01");
    //     b1.setLogicalTerminal(model.getRecieverSwiftCode());
    //     b1.setSessionNumber(String.valueOf(random.nextInt(9000) + 1000));
    //     b1.setServiceId(String.valueOf(randomNumber2));

    //      mt103.setSender(model.getSenderAccountNumber().getAccountNumber());
    //      mt103.setReceiver(model.getReceiverAccountNumber());
    //      mt103.addField(new Field20(generateRandom("MT103")));
    //      Field50a field50a = new Field50a()
    //      Field59F field59F = new Field59F();
    //      field59F.setNameAndAddress1(model.getReceiverLocation());
    //      mt103.addField(field59F);
    //      mt103.addField(new Field71A("SHA"));
    //     Field32A f32A = new Field32A()
    //             .setDate(Calendar.getInstance())
    //             .setCurrency("USD")
    //             .setAmount(model.getDebit());
    //     mt103.addField(f32A);
    //     return mt103.message();

    // }
    // private String generateRandom(String s) {
    // String random = s + RandomStringUtils.randomAlphanumeric(5);
    // return random;
    // }
    //
    // private String gererateDate() {
    // LocalDate today = LocalDate.now();
    // DateTimeFormatter dateTimeFormatter =
    // DateTimeFormatter.ofPattern("yy/MM/dd");
    // String date = today.format(dateTimeFormatter);
    // return date;
    // }

}