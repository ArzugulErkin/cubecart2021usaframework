package com.unitedcoder.integrationtest.database;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

public class DatabaseTestRunner {
    final static String dbUrl="148.72.106.125";
    final static String dbPort="3306";
    final static String username="testautomation";
    final static String password="automation123!";
    final static String defaultDatabase="cubecartqa1student";
    Connection connection=null;
    @BeforeClass
    public void setUp()
    {
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
    @Test(description = "verify a product in the database")
    public void verifyProductTest3()
    {
        DataAccess dataAccess=new DataAccess();
        Assert.assertTrue(dataAccess.getProductName("Ulkarabcdefghijklmn",connection));
    }
    @AfterClass
    public void tearDown()
    {
        ConnectionManager.closeDatabaseConnection(connection);
    }

}
