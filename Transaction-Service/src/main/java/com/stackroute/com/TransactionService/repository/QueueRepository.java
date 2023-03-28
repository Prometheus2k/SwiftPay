package com.stackroute.com.TransactionService.repository;

import com.stackroute.com.TransactionService.model.QueueModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QueueRepository extends JpaRepository<QueueModel, Integer> {
    List<QueueModel> findByStatus(String status);
}
