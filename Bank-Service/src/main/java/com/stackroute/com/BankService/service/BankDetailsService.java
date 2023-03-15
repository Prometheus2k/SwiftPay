package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.repository.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankDetailsService implements BankDetailsServiceInterface {
    @Autowired
    private BankDetailsRepository bankDetailsRepository;
}
