package com.unitedcoder.integrationtest.cubecarthttpapi;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.integrationtest.cubecartrestapi.PayloadUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApiTestRunner {
    private static String baseUrl;
    private static int port;
    private static String username;
    private static String password;
    private static String configFile="config-qa.properties";
    @BeforeClass
    public void setUp()
    {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        username=applicationConfig.readConfigProperties(configFile,"api.username");
        password=applicationConfig.readConfigProperties(configFile,"api.password");
        port=Integer.parseInt(applicationConfig.readConfigProperties(configFile,"api.port"));
        baseUrl=applicationConfig.readConfigProperties(configFile,"api.baseurl");
    }
    @Test(description = "authorized users should be able to get customers")
    public void getAllCustomersTest()
    {
        ApiRequestHandler apiRequestHandler=new ApiRequestHandler();
        ApiResponseHandler apiResponseHandler=apiRequestHandler.getAllCustomers(username,password,baseUrl,port,"customers");
        Assert.assertTrue(apiResponseHandler.getResponseCode()==200);
    }
    @Test(description = "authorized users should be able to add a customer")
    public void addACustomerTest()
    {
        ApiRequestHandler apiRequestHandler=new ApiRequestHandler();
        ApiResponseHandler apiResponseHandler=apiRequestHandler.addACustomer(username,password,baseUrl,port,"customer",
                PayloadUtility.getCustomerPayload());
        Assert.assertTrue(apiResponseHandler.getResponseCode()==200);
        Assert.assertTrue(apiResponseHandler.getResponseContent().contains("Dolkun"));
    }
}
