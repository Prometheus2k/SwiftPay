package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.CustomException;

public interface TransactionServiceInterface {

    public boolean verifyAccount(String accountNumber) throws CustomException;

}
