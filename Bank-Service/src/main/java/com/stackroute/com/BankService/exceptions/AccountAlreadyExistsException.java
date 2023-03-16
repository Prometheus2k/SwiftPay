package com.stackroute.com.BankService.exceptions;

public class AccountAlreadyExistsException extends Exception {
    public AccountAlreadyExistsException() {}

    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
