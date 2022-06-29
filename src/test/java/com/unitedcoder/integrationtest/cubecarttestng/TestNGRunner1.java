package com.unitedcoder.integrationtest.cubecarttestng;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.integrationtest.pageobjectpattern.CategoryPage;
import com.unitedcoder.integrationtest.pageobjectpattern.CustomerPage;
import com.unitedcoder.integrationtest.pageobjectpattern.DashboardPage;
import com.unitedcoder.integrationtest.pageobjectpattern.LoginPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Random;

@Listeners(CustomResultListener.class)  //using testng listener for test success or failure
public class TestNGRunner1 extends TestBase {
    final String configFile="config-qa.properties";
    @BeforeClass
    public void setUp(ITestContext context)
    {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        String username=applicationConfig.readConfigProperties(configFile,"username");
        String password= applicationConfig.readConfigProperties(configFile,"password");
        String url= applicationConfig.readConfigProperties(configFile,"url");
        if(Integer.parseInt(applicationConfig.readConfigProperties(configFile,"headless"))==1)
        {
            setUpBrowserInHeadlessMode(url);
        }
        else {
            setUpBrowser(url);
        }
        context.setAttribute("driver",driver); //setting webdriver in the test context
        //login
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
    }
    @Test(description = "Admin user should be able to add customer",groups = {"smoke"})
    public void addCustomerTest()
    {
        long timestamp=System.currentTimeMillis();
        CustomerPage customerPage=new CustomerPage(driver);
        boolean customerTestResult=customerPage.addCustomer("Dolkun"+timestamp,"Tarim"+timestamp,
                "abcd"+timestamp+"@test.com");
        Assert.assertTrue(customerTestResult);
    }

    @Test(description = "Admin user should see the products link on the dashboard page")
    public void verifyProductLinkTest()
    {
        DashboardPage dashboardPage=new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isProductLinkDisplayed());
    }

    @AfterClass
    public void tearDown()
    {
        closeBrowser();
        System.out.println("Total passed: "+CustomResultListener.passedTests.size());
        System.out.println("Total failed: "+CustomResultListener.failedTests.size());
    }

}
