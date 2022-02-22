package com.unitedcoder.integrationtest.cubecartjunit;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.json.*;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CubecartJunitAutomationDemo {
    static   FunctionLibrary functionLibrary=new FunctionLibrary(); //created an instance of the function library class
    static List<Product> productList=new ArrayList<>();   //to hold the test product
    static String configFile="config-qa.properties";
    static String timestamp=functionLibrary.getCurrentTimestampWithoutDash();

        @BeforeAll
        public static void setUp()
        {
            //open browser and login
            functionLibrary.openBrowser();
            ApplicationConfig applicationConfig=new ApplicationConfig();
            String username=applicationConfig.readConfigProperties(configFile,"username");
            String password=applicationConfig.readConfigProperties(configFile,"password");
            LoginUser loginUser=new LoginUser(username,password);
            functionLibrary.login(loginUser);
        }

    @Test
    @Tag("regression test")
    @Order(1)
    public void addCustomerTest(){
        String timestamp=functionLibrary.getCurrentTimestamp();
        Customer testCustomer=new Customer("zulhumar"+timestamp,"zul"+timestamp,"zul"+timestamp+"+@test.com");
        boolean testStatus=functionLibrary.addCustomer(testCustomer);
        Assertions.assertTrue(testStatus);
    }
    @Test
    @Order(2)
    @Tag("regression test")
    public void addProductTest() {
        Product product=new Product("iphone","iphone","cat_35","Apple");
        Product testProduct=new Product(product.getProductName()+timestamp,product.getProductCode()+timestamp,
                product.getProductCategory(),product.getProductManufacturer());
        productList.add(testProduct);
        boolean testStatus=functionLibrary.addProduct(product,timestamp);
        Assertions.assertTrue(testStatus);
    }

    @Test
    @Tag("Regession Test")
    @Order(3)
    public void productBulkPriceChangeTest()
    {
        boolean priceChangeTestResult= functionLibrary.priceChange(productList, ProductBulkPriceMethod.BY_AMOUNT,ProductPriceChangeAction.ADD,20);
        Assertions.assertTrue(priceChangeTestResult);
    }
    @AfterAll
    public static void tearDown()
    {
        //logout and close the browser
        functionLibrary.logout();
        functionLibrary.closeBrowser();
    }



}
