package com.stackroute.com.TransactionService.model;

@Entity
public class Transaction {

    private String accountNumber;
    private String beneficiaryName;
    private String receiverAccountNumber;
    private String receiverSwiftCode;
    private String bankName;
    private String bankAddress;
    private float debit;
    private float credit;
    private String message;


}
