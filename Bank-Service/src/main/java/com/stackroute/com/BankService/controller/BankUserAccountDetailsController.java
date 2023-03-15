package com.stackroute.com.BankService.controller;

import com.stackroute.com.BankService.service.BankUserAccountDetailsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank_user_account")
public class BankUserAccountDetailsController {
    @Autowired
    private BankUserAccountDetailsServiceInterface bankUserAccountDetailsServiceInterface;

    @GetMapping("/")
    public ResponseEntity<?> home() {
        ResponseEntity<?> entity = new ResponseEntity<String>("Welcome to bank user account details", HttpStatus.OK);
        return entity;
    }
}
