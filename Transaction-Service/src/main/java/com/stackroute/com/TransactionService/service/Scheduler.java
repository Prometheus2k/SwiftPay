package com.stackroute.com.TransactionService.service;

import com.stackroute.com.TransactionService.model.TransactionModel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {

//    @Scheduled(cron = "* */2 * * * *")
    public void schedule() {
        System.out.println("Inside scheduler----------");
    }

}
