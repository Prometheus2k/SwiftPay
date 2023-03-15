package com.stackroute.com.BankService.repository;

import com.stackroute.com.BankService.model.BankUserAccountDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BankUserAccountDetailsRepository extends JpaRepository<BankUserAccountDetailsModel, String> {
}
