package com.stackroute.com.TransactionService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stackroute.com.TransactionService.constants.BankName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="transactionId",nullable = false)
	private int transactionId;
	@Column(name="account_number",nullable = false,length = 20)
	private String accountNumber;

//	@CreationTimestamp
//	@Column(name = "created_at")
//	private Date createdAt;

	@Column(updatable = false)
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createdAt;
	@Column(name="beneficiary_name",nullable = false)
	private String beneficiaryName;

	@Column(name = "timeStamp",updatable = false)
	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timeStamp;
	@Column(name="receiver_account_number",nullable = false)
	private String receiverAccountNumber;
	@Column(name="receiver_swift_code",nullable = false,length = 8)
	private String receiverSwiftCode;
	@Column(name="bank_name",nullable = false)
	@Enumerated(EnumType.STRING)
	private BankName bankName;
	@Column(name="credit",nullable = false)
	private float credit;
	@Column(name="debit",nullable = false)
	private float debit;
	@Column(name="message",nullable = false)
	private String message;



}
