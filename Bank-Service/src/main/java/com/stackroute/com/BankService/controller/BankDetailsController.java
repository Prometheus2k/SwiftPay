package com.stackroute.com.BankService.controller;

import com.stackroute.com.BankService.service.BankDetailsService;
import com.stackroute.com.BankService.service.BankDetailsServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank_details")
public class BankDetailsController {
    @Autowired
    private BankDetailsService bankDetailsService;

    @GetMapping("/")
    public ResponseEntity<?> home() {
        ResponseEntity<?> entity = new ResponseEntity<String>("Welcome to bank details", HttpStatus.OK);
        return entity;
    }
}
