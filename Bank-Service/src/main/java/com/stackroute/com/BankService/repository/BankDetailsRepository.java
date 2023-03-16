package com.stackroute.com.BankService.repository;

import com.stackroute.com.BankService.model.BankDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface BankDetailsRepository extends JpaRepository<BankDetailsModel, Integer> {
    public Optional<BankDetailsModel> findByBankId(int bankId);
}
