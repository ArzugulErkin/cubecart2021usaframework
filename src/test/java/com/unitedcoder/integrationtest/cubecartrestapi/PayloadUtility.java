package com.unitedcoder.integrationtest.cubecartrestapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadUtility {
    public static String getCustomerPayload()
    {
        long timestamp=System.currentTimeMillis();
        String payload=null;
        CustomerPayload testCustomerPayload=new CustomerPayload(
                "DolkunCustomer"+timestamp+"@test.com",
                "Mr","Dolkun"+timestamp,"Tarim"+timestamp,
                "0","123456789",1,"en-GB","111.222.333.444");
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            payload=objectMapper.writeValueAsString(testCustomerPayload);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return payload;
    }
}
