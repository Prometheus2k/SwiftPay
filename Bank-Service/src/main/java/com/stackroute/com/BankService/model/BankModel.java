package com.stackroute.com.BankService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bank_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bankId;
    @Column(name = "bank_name", nullable = false)
    private String bankName;
    @Column(name = "bank_swift_code", nullable = false, length = 8)
    private String bankSwiftCode;
}
