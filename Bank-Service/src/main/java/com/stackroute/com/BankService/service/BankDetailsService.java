package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.BankAlreadyExistsException;
import com.stackroute.com.BankService.model.BankDetailsModel;
import com.stackroute.com.BankService.repository.BankDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankDetailsService implements BankDetailsServiceInterface {
    @Autowired
    private BankDetailsRepository bankDetailsRepository;


    @Override
    public void addBankDetails(BankDetailsModel bankDetailsModel) throws BankAlreadyExistsException {
        Optional<BankDetailsModel> optional = bankDetailsRepository.findById(bankDetailsModel.getBankId());
        if(optional.isPresent()) {
            throw new BankAlreadyExistsException("Bank details already exists with this bank name");
        }
        bankDetailsRepository.save(bankDetailsModel);
    }

    @Override
    public List<BankDetailsModel> getAllBankDetails() {
        return bankDetailsRepository.findAll();
    }
}