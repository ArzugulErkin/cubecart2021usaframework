package com.unitedcoder.integrationtest.pageobjectpattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageObjectPatternJUnitRunner {
    static WebDriver driver;
    static String timestamp;
    @BeforeAll
    public static void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.login("testautomation1","automation123!");
        FunctionPage functionPage=new FunctionPage(driver);
        timestamp=functionPage.getCurrentTimestampWithoutDash();
    }
    @Test
    public void verifyProductLinkTest()
    {
        DashboardPage dashboardPage=new DashboardPage(driver);
        Assertions.assertTrue(dashboardPage.isProductLinkDisplayed());
    }
    @Test
    public void addCustomerTest()
    {
        CustomerPage customerPage=new CustomerPage(driver);

     boolean result= customerPage.addCustomer("Dolkun"+timestamp,
                "Tarim"+timestamp,"Dolkun"+timestamp+"@test.com");
     Assertions.assertTrue(result);
    }
    @Test
    public void addCategoryTest()
    {
        CategoryPage categoryPage=new CategoryPage(driver);
      Assertions.assertTrue(categoryPage.addNewCategory("UnitedCoderSDET"+timestamp));
    }

    @AfterAll
    public static void tearDown()
    {
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.logout();
        driver.quit();
    }
}
