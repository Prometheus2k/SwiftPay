package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.CustomException;

public interface TransactionServiceInterface {

    boolean verifyAccount(String accountNumber) throws CustomException;

}
