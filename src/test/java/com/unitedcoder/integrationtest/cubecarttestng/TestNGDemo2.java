package com.unitedcoder.integrationtest.cubecarttestng;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGDemo2 {
    @BeforeClass
    public void setUp()
    {
        System.out.println("the method in Before class in TestNG runs only once before test");
    }
    @BeforeMethod
    public void printTestBeginInfo()
    {
        System.out.println("In TestNG, before method will run before every test");
    }
    @BeforeTest
    public void beforeTestDummy()
    {
        System.out.println("This is before test");
    }


    @Test(description = "add product test",groups = {"Smoke","Regression"},invocationCount = 2)
    public void addProductTest()
    {
        System.out.println("This is a test for adding a product");
        Assert.assertTrue("Add product".contains("product"));
    }

    @Test(description = "category link verification test",groups = "Smoke",invocationCount = 2)
    public void verifyCategoryLinkTest()
    {
        System.out.println("This is for the category link verification");
        Assert.assertTrue(Math.pow(10,2)==100);
    }

    @Test(description = "verify inventory link test",groups = "Regression",enabled = false)
    public void verifyInventoryLinkTest()
    {
        System.out.println("This is a test for the inventory link verification");
        Assert.assertTrue("Inventory Link".length()>5);
    }
    @AfterTest
    public void afterTestDummy()
    {
        System.out.println("This is after test");
    }

    @AfterMethod
    public void printTestAfterInfo()
    {
        System.out.println("In TestNG, after method will run after each test");
    }
    @AfterClass
    public void tearDown()
    {
        System.out.println("after class in TestNG runs once after all tests are completed");
    }
}
