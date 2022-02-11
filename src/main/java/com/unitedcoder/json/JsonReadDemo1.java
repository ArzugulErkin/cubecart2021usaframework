package com.unitedcoder.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonReadDemo1 {
    public static void main(String[] args) {
        //we read a json file and map the file content to an object using Object Mapper
        ObjectMapper objectMapper=new ObjectMapper();
        try {
            CubecartTestData cubecartTestData=objectMapper.readValue(new File("doc\\cubecart_test.json"),CubecartTestData.class);
            System.out.println(cubecartTestData.getLoginUser().toString());
            System.out.println(cubecartTestData.getCustomer().toString());
            System.out.println(cubecartTestData.getProduct().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
