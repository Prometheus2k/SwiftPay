package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BankService implements BankServiceInterface {
    @Autowired
    private BankRepository bankRepository;
}
