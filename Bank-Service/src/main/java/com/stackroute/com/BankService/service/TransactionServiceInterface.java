package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.CustomException;
import com.stackroute.com.BankService.model.TransactionModel;

import java.util.List;

public interface TransactionServiceInterface {

    public boolean performTransaction(TransactionModel model) throws CustomException;

    public List<TransactionModel> viewAllTransactions();

}
