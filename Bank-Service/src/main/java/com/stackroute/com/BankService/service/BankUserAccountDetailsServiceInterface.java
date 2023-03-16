package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.AccountAlreadyExistsException;
import com.stackroute.com.BankService.model.BankUserAccountDetailsModel;

import java.util.List;

public interface BankUserAccountDetailsServiceInterface {
    public void addUserAccountDetails(BankUserAccountDetailsModel bankUserAccountDetailsModel) throws AccountAlreadyExistsException;

    public List<BankUserAccountDetailsModel> viewUserAccountDetails();
}
