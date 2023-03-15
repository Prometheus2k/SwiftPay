package com.stackroute.com.BankService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bank_user_account_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankUserAccountDetails {
    @Id
    private String accountNumber;
    @Column(name = "user_email_id", nullable = false)
    private String userEmailId;
    @Enumerated(EnumType.STRING)
    @Column(name = "bank_account_type", nullable = false)
    private BankAccountTypeEnum bankAccountTypeEnum;
    @ManyToOne
    private BankDetails bankDetails;
    @Column(name = "bank_swift_code", nullable = false)
    private String branchSwiftCode;
    @Column
    private long balance;
}
