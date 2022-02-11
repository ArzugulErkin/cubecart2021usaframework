package com.unitedcoder.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class AutomationWithJsonData {
    public static void main(String[] args) {
        //map json data to test data object
        ObjectMapper objectMapper=new ObjectMapper();
        CubecartTestData cubecartTestData=new CubecartTestData();
        try {
            cubecartTestData=objectMapper.readValue(new File("doc\\cubecart_test.json"),CubecartTestData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FunctionLibrary functionLibrary=new FunctionLibrary();
        //login
        functionLibrary.openBrowser();
        functionLibrary.login(cubecartTestData.getLoginUser());
        for(int i=0;i<2;i++) {
            //add a customer
            functionLibrary.addCustomer(cubecartTestData.getCustomer());
            //add a product
            functionLibrary.addProduct(cubecartTestData.getProduct());
        }
        //logout
        functionLibrary.logout();
        //close the browser
        functionLibrary.closeBrowser();
    }
}
