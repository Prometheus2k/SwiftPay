package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.repository.BankUserAccountDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankUserAccountDetailsService implements BankUserAccountDetailsServiceInterface {
    @Autowired
    private BankUserAccountDetailsRepository bankUserAccountDetailsRepository;
}
