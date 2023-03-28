package com.stackroute.com.TransactionService.swift;

import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.model.mt.mt1xx.MT101;
import com.prowidesoftware.swift.model.mt.mt9xx.MT900;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;

@Service
public class SwiftOperation {

    public String generateMT900(String message) throws IOException {
        AbstractMT abstractMT = AbstractMT.parse(message);
        MT101 mt101 = (MT101) abstractMT;
        MT900 mt900 = new MT900();
        mt900.addField(new Field20(mt101.getField20().getValue()));
        mt900.addField(new Field25(mt101.getSender()));
        mt900.addField(new Field21(mt101.getField21().get(0).asTag().getValue()));
        mt900.addField(new Field32A().setDate(mt101.getField30().getDate())
                .setCurrency(mt101.getField32B().get(0).getCurrency())
                .setAmount(mt101.getField32B().get(0).getCurrency()));
        return mt900.message();
    }

}
