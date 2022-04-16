package com.unitedcoder.integrationtest.database;

import com.unitedcoder.configutility.ApplicationConfig;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

public class DatabaseTestRunner {
    Connection connection=null;
    ApplicationConfig applicationConfig;
    final static String configFile="config-qa.properties";
    @BeforeClass
    public void setUp()
    {
        applicationConfig=new ApplicationConfig();
        String dbUrl=applicationConfig.readConfigProperties(configFile,"standalone.dbUrl");
        String dbPort=applicationConfig.readConfigProperties(configFile,"standalone.dbPort");
        String defaultDatabase=applicationConfig.readConfigProperties(configFile,"standalone.defaultDatabase");
        String username=applicationConfig.readConfigProperties(configFile,"standalone.username");
        String password=applicationConfig.readConfigProperties(configFile,"standalone.password");
        connection=ConnectionManager.connectToDatabaseServer(dbUrl,dbPort,defaultDatabase,
                username,password,ConnectionType.MYSQL);
    }
    @Test(description = "verify a product in the database")
     public void verifyProductTest1()
    {
        DataAccess dataAccess=new DataAccess();
        Assert.assertTrue(dataAccess.getProductName("Ulkar1645197280952",connection));
    }
    @Test(description = "verify a product in the database")
    public void verifyProductTest2()
    {
        DataAccess dataAccess=new DataAccess();
        Assert.assertTrue(dataAccess.getProductName("Ulkar1645197281998",connection));
    }
    @Test(description = "verify a customer in the database")
    public void verifyCustomerTest()
    {
        DataAccess dataAccess=new DataAccess();
        Assert.assertTrue(dataAccess.getCustomerName("almas2022-02-19-09-09-21-982@test.com",connection));
    }
    @Test(description ="Admin user should be able to insert record into cubecart category table")
    public void insertCategoryTest()
    {
       String currentTimeStamp=String.valueOf(System.currentTimeMillis());
       CategoryObject testCategory=new CategoryObject(
               "Dilmuray Category"+currentTimeStamp,
               "Dilmurat Description "+currentTimeStamp,
               0,0,0,0,0,0,0,
               "Dilmurat test category title","Dolkun Test Category Description",
               "Dilmurat Test",1,1);
       DataAccess dataAccess=new DataAccess();
       Assert.assertTrue(dataAccess.insertNewCategory(testCategory,connection));
    }

    @AfterClass
    public void tearDown()
    {
        ConnectionManager.closeDatabaseConnection(connection);
    }

}
