package com.stackroute.com.TransactionService.service;



import com.stackroute.com.TransactionService.exceptions.CustomException;
import com.stackroute.com.TransactionService.model.AccountModel;
import com.stackroute.com.TransactionService.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements AccountServiceInterface{

    @Autowired
    private AccountRepository repository;
    @Override
    public AccountModel getAccountByUserEmailId(String emailId) throws CustomException {
        Optional<AccountModel> optional = repository.findByUserEmailId(emailId);
        AccountModel account = optional.isEmpty() ? null : optional.get();
        if(account == null) {
            throw new CustomException("Invalid User");
        }
        else {
            return account;
        }
    }
}
