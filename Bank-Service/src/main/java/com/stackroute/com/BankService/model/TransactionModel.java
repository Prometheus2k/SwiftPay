package com.stackroute.com.BankService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    @Column
    private String senderAccountNumber;
    @Column
    private String receiverName;
    @Column
    private String receiverAccountNumber;
    @Column
    private String receiverSwiftCode;
    @Column
    private String fromBankName;
    @Column
    private String toBankName;
    @Column
    private String toBankAddress;
    @Column
    private BigInteger debit;
    @Column
    private BigInteger credit;
    @Column
    private String message;
    @Column
    private boolean status;
}
