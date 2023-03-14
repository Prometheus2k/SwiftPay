package com.stackroute.com.BankService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    @Id
    private String accountNumber;
    @Column(name = "user_email_id", nullable = false)
    private String userEmailId;
    @Column(name = "branch_swift_code", nullable = false)
    private String branchSwiftCode;
    @Column(name = "branch_location")
    private String branchLocation;
    @Enumerated(EnumType.STRING)
    @Column(name = "bank_account_type")
    private BankAccountType bankAccountType;
    @Column(name = "balance")
    private long balance;
}
