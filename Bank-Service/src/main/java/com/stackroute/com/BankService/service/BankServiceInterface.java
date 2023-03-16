package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.CustomException;
import com.stackroute.com.BankService.model.BankModel;

import java.util.List;

public interface BankServiceInterface {
    public void addBankDetails(BankModel bank) throws CustomException;

    public List<BankModel> getAllBankDetails();

    public BankModel getBankById(int bankId) throws CustomException;

    public void deleteBankByBankId(int bankId) throws CustomException;

    public void updateBankById(int bankId, BankModel bank) throws CustomException;
}
