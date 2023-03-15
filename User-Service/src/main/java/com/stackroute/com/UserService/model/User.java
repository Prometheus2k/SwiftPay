package com.stackroute.com.UserService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
//@Table(name='user_master')
public class User {
    @Id
    @Column(name="email_id",length=30)
    private String emailId;
    @Column(length=30)
    private String password;
    @Column(name="user_name",length=30)
    private String nameOftheUser;
    @Column(name="mobile_number",length=10)
    private String mobileNumber;

    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNameOftheUser() {
        return nameOftheUser;
    }
    public void setNameOftheUser(String nameOftheUser) {
        this.nameOftheUser = nameOftheUser;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    @Override
    public String toString() {
        return "User [emailId=" + emailId + ", password=" + password + ", nameOftheUser=" + nameOftheUser
                + ", mobileNumber=" + mobileNumber + "]";
    }






}
