package com.stackroute.com.BankService.service;

import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.model.mt.mt9xx.MT900;
import com.stackroute.com.BankService.exceptions.CustomException;
import com.stackroute.com.BankService.model.AccountModel;
import com.stackroute.com.BankService.model.TransactionModel;
import com.stackroute.com.BankService.repository.AccountRepository;
import com.stackroute.com.BankService.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class TransactionService implements TransactionServiceInterface {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void addTransactionDetails(TransactionModel transactionModel, String MT101) {
        transactionModel.setMessage(MT101);
        transactionRepository.save(transactionModel);
    }

    @Override
    public void updateStatus(int transactionId, String status) throws CustomException {
        Optional<TransactionModel> optional = transactionRepository.findByTransactionId(transactionId);
        TransactionModel model = optional.isEmpty() ? null : optional.get();
        if(model == null) {
            throw new CustomException("No transaction found with id");
        }
        model.setStatus(status);
        transactionRepository.save(model);
    }

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

    @Override
    public boolean checkBalance(String accountNumber, float balance) throws CustomException{
        Optional<AccountModel> optional = accountRepository.findByAccountNumber(accountNumber);
        AccountModel model = optional.isEmpty() ? null :optional.get();
        if(model == null) {
            throw new CustomException("Account number does not exist");
        }
        else if(model.getBalance() < balance) {
            throw new CustomException("Balance is low");
        }
        else {
            return true;
        }
    }

    @Override
    public void executeDebit(String MT900) throws IOException {
        AbstractMT abstractMT = AbstractMT.parse(MT900);
        MT900 mt900 = (MT900) abstractMT;
        String debitAmount = String.valueOf(mt900.getField32A().getAmount()).replace(",", "");
        String accountNumber = mt900.getField25().getAccount();
        Optional<AccountModel> optional = accountRepository.findByAccountNumber(accountNumber);
        AccountModel accountModel = optional.isEmpty() ? null : optional.get();
        accountModel.setBalance(accountModel.getBalance() - Long.parseLong(debitAmount));
        accountRepository.save(accountModel);
    }
}
