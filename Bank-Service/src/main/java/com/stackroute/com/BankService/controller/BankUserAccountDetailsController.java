package com.stackroute.com.BankService.controller;

import com.stackroute.com.BankService.exceptions.AccountAlreadyExistsException;
import com.stackroute.com.BankService.exceptions.BankAlreadyExistsException;
import com.stackroute.com.BankService.model.BankUserAccountDetailsModel;
import com.stackroute.com.BankService.service.BankUserAccountDetailsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bank_user_account")
public class BankUserAccountDetailsController {
    @Autowired
    private BankUserAccountDetailsServiceInterface service;

    @GetMapping("/")
    public ResponseEntity<?> home() {
        ResponseEntity<?> entity = new ResponseEntity<String>("Welcome to bank user account details", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUserAccountDetails(@RequestBody BankUserAccountDetailsModel model) {
        ResponseEntity<?> entity = null;
        try {
            service.addUserAccountDetails(model);
            entity = new ResponseEntity<String>("Account details added successfully", HttpStatus.OK);
        }
        catch (AccountAlreadyExistsException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }

    @GetMapping("/view")
    public ResponseEntity<?> viewAllAccounts() {
        List<BankUserAccountDetailsModel> allUserList = service.viewUserAccountDetails();
        ResponseEntity<?> entity = new ResponseEntity<List<BankUserAccountDetailsModel>>(allUserList, HttpStatus.OK);
        return entity;
    }
}
