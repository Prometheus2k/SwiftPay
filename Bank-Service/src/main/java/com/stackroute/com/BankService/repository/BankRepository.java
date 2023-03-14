package com.stackroute.com.BankService.repository;

import com.stackroute.com.BankService.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BankRepository extends JpaRepository<Bank, Integer> {
}