package com.unitedcoder.integrationtest.cubecarttestng;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.integrationtest.pageobjectpattern.CategoryPage;
import com.unitedcoder.integrationtest.pageobjectpattern.CustomerPage;
import com.unitedcoder.integrationtest.pageobjectpattern.DashboardPage;
import com.unitedcoder.integrationtest.pageobjectpattern.LoginPage;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.Random;

@Listeners(CustomResultListener.class)  //using testng listener for test success or failure
public class TestNGDataProviderDemoTest extends TestBase {
    final String configFile="config-qa.properties";
    @BeforeClass
    public void setUp(ITestContext context)
    {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        String username=applicationConfig.readConfigProperties(configFile,"username");
        String password= applicationConfig.readConfigProperties(configFile,"password");
        String url= applicationConfig.readConfigProperties(configFile,"url");
        setUpBrowser(url);
        context.setAttribute("driver",driver); //setting webdriver in the test context
        //login
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login(username,password);
    }
    @Test(dataProvider ="myTestCustomer", description = "Admin user should be able to add customer",groups = {"smoke"})
    public void addCustomerTest(String firstName,String lastName,String email)
    {
        long timestamp=System.currentTimeMillis();
        CustomerPage customerPage=new CustomerPage(driver);
        boolean customerTestResult=customerPage.addCustomer(firstName+timestamp,lastName+timestamp,
                email+timestamp+"@test.com");
        Assert.assertTrue(customerTestResult);
    }

    @Test(dataProvider = "myTestCategories",description = "Admin user should be able to add categories",groups = {"smoke"})
    public void addCategoryTest(String categoryName)
    {
        Random random=new Random();
        CategoryPage categoryPage=new CategoryPage(driver);
      Assert.assertTrue(categoryPage.addNewCategory(categoryName+random.nextInt(1000000)));
    }

   @DataProvider
   public Object[][] myTestCustomer()
   {
       Object[][] customers=new Object[][]{
               {"Jason","Smith","jason.smith"},
               {"Mike","Pence","mike.pence"},
               {"Jackie","Jackson","jackie.jackson"},
               {"Michael","Bolton","michael.bolton"}
       };
       return customers;
   }
   @DataProvider
   public Object[][] myTestCategories()
   {
       Object[][] categories=new Object[][]{
               {"Apple"},
               {"Gucci"},
               {"Channel"},
               {"Boss"}
       };
       return categories;
   }


    @AfterClass
    public void tearDown()
    {
        closeBrowser();
        System.out.println("Total passed: "+CustomResultListener.passedTests.size());
        System.out.println("Total failed: "+CustomResultListener.failedTests.size());
    }

}
