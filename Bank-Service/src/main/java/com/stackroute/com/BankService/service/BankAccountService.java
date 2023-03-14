package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BankAccountService implements BankAccountServiceInterface {
    @Autowired
    private BankAccountRepository bankAccountRepository;
}
