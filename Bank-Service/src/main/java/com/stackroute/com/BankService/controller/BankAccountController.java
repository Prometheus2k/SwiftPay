package com.stackroute.com.BankService.controller;

import com.stackroute.com.BankService.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bank_account")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;
}
