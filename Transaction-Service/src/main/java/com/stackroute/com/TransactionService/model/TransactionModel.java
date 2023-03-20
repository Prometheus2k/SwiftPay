package com.stackroute.com.TransactionService.model;

import com.stackroute.com.TransactionService.constants.BankName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionModel {
	@Id
	@Column(name="account_number",nullable = false,length = 20)
	private String accountNumber;
	@Column(name="beneficiary_name",nullable = false)
	private String beneficiaryName;
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
