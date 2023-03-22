package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.CustomException;
import com.stackroute.com.BankService.model.TransactionModel;
import com.stackroute.com.BankService.repository.AccountRepository;
import com.stackroute.com.BankService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements TransactionServiceInterface {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean performTransaction(TransactionModel model) throws CustomException {

        return false;
    }

    @Override
    public List<TransactionModel> viewAllTransactions() {
        return transactionRepository.findAll();
    }
}
