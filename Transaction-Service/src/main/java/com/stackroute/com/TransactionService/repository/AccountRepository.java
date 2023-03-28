package com.stackroute.com.TransactionService.repository;

import com.stackroute.com.TransactionService.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
@Transactional
public interface AccountRepository extends JpaRepository <AccountModel, String>{

    public Optional<AccountModel> findByUserEmailId(String emailId);
}
