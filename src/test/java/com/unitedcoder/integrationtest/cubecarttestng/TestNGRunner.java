package com.unitedcoder.integrationtest.cubecarttestng;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.integrationtest.pageobjectpattern.CategoryPage;
import com.unitedcoder.integrationtest.pageobjectpattern.CustomerPage;
import com.unitedcoder.integrationtest.pageobjectpattern.DashboardPage;
import com.unitedcoder.integrationtest.pageobjectpattern.LoginPage;
import com.unitedcoder.json.FunctionLibrary;
import com.unitedcoder.json.Product;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class TestNGRunner extends TestBase {
    final String configFile="config-qa.properties";
    @BeforeClass
    public void setUp()
    {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        String username=applicationConfig.readConfigProperties(configFile,"username");
        String password= applicationConfig.readConfigProperties(configFile,"password");
        String url= applicationConfig.readConfigProperties(configFile,"url");
        setUpBrowser(url);
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

    @Test(description = "Admin user should be able to add categories",groups = {"smoke"})
    public void addCategoryTest()
    {
        Random random=new Random();
        CategoryPage categoryPage=new CategoryPage(driver);
      Assert.assertTrue(categoryPage.addNewCategory("Dell Computer"+random.nextInt(1000)));
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
    }

}
