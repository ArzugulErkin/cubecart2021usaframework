package com.unitedcoder.integrationtest.database;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.integrationtest.cubecarttestng.TestBase;
import com.unitedcoder.integrationtest.pageobjectpattern.CategoryPage;
import com.unitedcoder.integrationtest.pageobjectpattern.CustomerPage;
import com.unitedcoder.integrationtest.pageobjectpattern.LoginPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Connection;

public class UIDatabaseTestRunner extends TestBase {
    final String configFile="config-qa.properties";
    Connection connection=null;
    @BeforeClass
    public void setUp(ITestContext context)
    {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        String username=applicationConfig.readConfigProperties(configFile,"username");
        String password= applicationConfig.readConfigProperties(configFile,"password");
        String url= applicationConfig.readConfigProperties(configFile,"url");
        //check the headless mode in the browser
        int headlessMode=Integer.parseInt(applicationConfig.readConfigProperties(configFile,"headless"));
        if(headlessMode==1)
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
        //for database
        String dbUrl=applicationConfig.readConfigProperties(configFile,"qa.dbUrl");
        String dbPort=applicationConfig.readConfigProperties(configFile,"qa.dbPort");
        String defaultDatabase=applicationConfig.readConfigProperties(configFile,"qa.defaultDatabase");
        String dbusername=applicationConfig.readConfigProperties(configFile,"qa.username");
        String dbpassword=applicationConfig.readConfigProperties(configFile,"qa.password");
        connection=ConnectionManager.connectToDatabaseServer(dbUrl,dbPort,defaultDatabase,
                dbusername,dbpassword,ConnectionType.MYSQL);

    }
    @Test(description = "Admin user should be able to add customer",groups = {"addCustomer"})
    public void addCustomerTest()
    {
        long timestamp=System.currentTimeMillis();
        CustomerPage customerPage=new CustomerPage(driver);
        String customerFirstName="Dolkun"+timestamp;
        String customerLastName="Tarim"+timestamp;
        String customerEmail="abcd"+timestamp+"@test.com";
        TestDataHolder.setCustomerEmail(customerEmail); //store the customer email in the test data holder object
        boolean customerTestResult=customerPage.addCustomer(customerFirstName,customerLastName, customerEmail);
        Assert.assertTrue(customerTestResult);
    }
    @Test(description = "admin user should be able to verify the customer in the database",dependsOnGroups = {"addCustomer"})
    public void verifyCustomerInDatabaseTest()
    {
        DataAccess dataAccess=new DataAccess();
        boolean isCustomerExist=dataAccess.getCustomerName(TestDataHolder.getCustomerEmail(),connection);
        Assert.assertTrue(isCustomerExist);
    }

    @Test(description = "Admin user should be able to add categories",groups = {"addCategory"})
    public void addCategoryTest()
    {
        long timestamp=System.currentTimeMillis();
        String categoryName="DellComputer-"+timestamp;
        TestDataHolder.setCategoryName(categoryName); //store the category in the test data holder
        CategoryPage categoryPage=new CategoryPage(driver);
        Assert.assertTrue(categoryPage.addNewCategory(categoryName));
    }
    @Test(description = "admin user should be able to verify the category in the database",dependsOnGroups = {"addCategory"})
    public void verifyCategoryInDatabaseTest()
    {
        DataAccess dataAccess=new DataAccess();
        boolean isCategoryExist=dataAccess.getCategoryName(TestDataHolder.getCategoryName(),connection);
        Assert.assertTrue(isCategoryExist);
    }

    @AfterClass
    public void tearDown()
    {
        closeBrowser();
        ConnectionManager.closeDatabaseConnection(connection);
    }
}
