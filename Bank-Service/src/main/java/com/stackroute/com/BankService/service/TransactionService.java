package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.CustomException;
import com.stackroute.com.BankService.model.AccountModel;
import com.stackroute.com.BankService.repository.AccountRepository;
import com.stackroute.com.BankService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService implements TransactionServiceInterface {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean verifyAccount(String accountNumber) throws CustomException {
        Optional<AccountModel> optional = accountRepository.findByAccountNumber(accountNumber);
        AccountModel model = optional.isEmpty() ? null : optional.get();
        if(model == null) {
            throw new CustomException("Account number not found");
        }
        else {
            return true;
        }
    }
}
