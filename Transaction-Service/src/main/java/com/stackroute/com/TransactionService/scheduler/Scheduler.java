package com.stackroute.com.TransactionService.scheduler;

import com.stackroute.com.TransactionService.interservice.InterService;
import com.stackroute.com.TransactionService.model.QueueModel;
import com.stackroute.com.TransactionService.repository.QueueRepository;
import com.stackroute.com.TransactionService.swift.SwiftOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Scheduler {

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private SwiftOperation swiftOperation;

    @Autowired
    private InterService interService;

    @Scheduled(cron = "*/120 * * * * *")
    public void scheduler() {
        List<QueueModel> listOfPending = queueRepository.findByStatus("PENDING");
        try {
            if(listOfPending.size() != 0) {
                for (QueueModel model : listOfPending) {

                    String MT103 = swiftOperation.generateMT103FromMT101(model.getMessage());

                    System.out.println("-------------MT103----------------");
                    System.out.println(MT103);
                    System.out.println("-----------------------------------");

                    String MT910 = swiftOperation.generateMT910FromMT103(MT103);
                    interService.executeCredit(MT910);
                    model.setStatus("COMPLETED");
                    queueRepository.save(model);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



    }

}
