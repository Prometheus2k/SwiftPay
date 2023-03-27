//package com.stackroute.com.BankService.model;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Data
//@Table(name = "transactions")
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class TransactionModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int transactionId;
//    @ManyToOne
//    private AccountModel senderAccountNumber;
//    @Column(updatable = false)
//    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private LocalDateTime time;
//    @Column
//    private String receiverName;
//    @Column
//    private String receiverAccountNumber;
//    @Column
//    private String receiverSwiftCode;
//    @ManyToOne
//    private BankModel receiverBankName;
//    @Column
//    private float credit;
//    @Column
//    private float debit;
//    @Column
//    private String message;
//    @Column
//    private String senderLocation;
//    @Column
//    private String receiverLocation;
//}
