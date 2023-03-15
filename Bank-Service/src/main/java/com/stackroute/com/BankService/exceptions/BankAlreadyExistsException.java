package com.stackroute.com.BankService.exceptions;

public class BankAlreadyExistsException extends Exception {
    public BankAlreadyExistsException() {}

    public BankAlreadyExistsException(String message) {
        super(message);
    }
}
