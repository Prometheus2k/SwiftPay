package com.stackroute.com.BankService.controller;

import com.stackroute.com.BankService.exceptions.BankAlreadyExistsException;
import com.stackroute.com.BankService.model.BankDetailsModel;
import com.stackroute.com.BankService.service.BankDetailsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bank_details")
public class BankDetailsController {
    @Autowired
    private BankDetailsServiceInterface service;

    @GetMapping("/")
    public ResponseEntity<?> home() {
        ResponseEntity<?> entity = new ResponseEntity<String>("Welcome to bank details", HttpStatus.OK);
        return entity;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addBankDetails(@RequestBody BankDetailsModel model) {
        ResponseEntity<?> entity = null;
        try {
            service.addBankDetails(model);
            entity = new ResponseEntity<String>("Bank details added successfully", HttpStatus.OK);
        }
        catch (BankAlreadyExistsException e) {
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
        }
        return entity;
    }
    @GetMapping("/view")
    public ResponseEntity<?> viewAllBanks() {
        List<BankDetailsModel> allBankList = service.getAllBankDetails();
        ResponseEntity<?> entity = new ResponseEntity<List<BankDetailsModel>>(allBankList, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/view/{bankId}")
    public ResponseEntity<?> getBankById(@PathVariable("bankId") int bankId) {
        ResponseEntity<?> entity = null;
        BankDetailsModel model = service.getBankById(bankId);
        if(model == null) {
            entity = new ResponseEntity<String>("Bank does not exist", HttpStatus.OK);
        }
        else {
            entity = new ResponseEntity<BankDetailsModel>(model, HttpStatus.OK);
        }
        return entity;
    }



}
