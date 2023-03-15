package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.BankAlreadyExistsException;
import com.stackroute.com.BankService.model.BankDetailsModel;

import java.util.List;

public interface BankDetailsServiceInterface {
    public void addBankDetails(BankDetailsModel bankDetailsModel) throws BankAlreadyExistsException;
    public List<BankDetailsModel> getAllBankDetails();
}
