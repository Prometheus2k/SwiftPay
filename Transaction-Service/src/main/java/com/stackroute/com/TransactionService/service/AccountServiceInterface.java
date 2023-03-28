package com.stackroute.com.TransactionService.service;

import com.stackroute.com.TransactionService.exceptions.CustomException;
import com.stackroute.com.TransactionService.model.AccountModel;

public interface AccountServiceInterface {

    public AccountModel getAccountByUserEmailId(String emailId) throws CustomException;
}
