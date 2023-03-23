package com.stackroute.com.BankService.swift;

import com.prowidesoftware.swift.model.mt.AbstractMT;

import java.io.IOException;

public class SwiftValidation {

    private final static String MT101 = "101";
    private final static String MT103 = "103";
    private final static String MT202 = "202";
    private final static String MT900 = "900";
    private final static String MT910 = "910";
    private final static String MT920 = "920";

    public String swiftValidator(String swiftMessage) throws IOException {
        AbstractMT abstractMT = AbstractMT.parse(swiftMessage);
        return null;
    }

}
