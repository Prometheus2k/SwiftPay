package com.stackroute.com.BankService.service;

import com.stackroute.com.BankService.exceptions.AccountAlreadyExistsException;
import com.stackroute.com.BankService.model.BankUserAccountDetailsModel;
import com.stackroute.com.BankService.repository.BankUserAccountDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankUserAccountDetailsService implements BankUserAccountDetailsServiceInterface {
    @Autowired
    private BankUserAccountDetailsRepository repository;

    @Override
    public void addUserAccountDetails(BankUserAccountDetailsModel bankUserAccountDetailsModel) throws AccountAlreadyExistsException {
        Optional<BankUserAccountDetailsModel> optional = repository.findById(bankUserAccountDetailsModel.getAccountNumber());
        if(optional.isPresent()) {
            throw new AccountAlreadyExistsException("Bank account already exists");
        }
        repository.save(bankUserAccountDetailsModel);
    }

    @Override
    public List<BankUserAccountDetailsModel> viewUserAccountDetails() {
        return repository.findAll();
    }
}
