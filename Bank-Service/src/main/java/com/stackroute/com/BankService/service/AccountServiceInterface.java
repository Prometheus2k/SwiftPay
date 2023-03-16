package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.CustomException;
import com.stackroute.com.BankService.model.AccountModel;

import java.util.List;

public interface AccountServiceInterface {
    public void addAccountDetails(AccountModel accountModel) throws CustomException;

    public List<AccountModel> viewAllAccounts();

    public AccountModel getAccount(String accountNumber) throws CustomException;

    public void deleteAccount(String accountNumber) throws CustomException;

    public void updateAccount(String accountNumber, AccountModel account) throws CustomException;
}
