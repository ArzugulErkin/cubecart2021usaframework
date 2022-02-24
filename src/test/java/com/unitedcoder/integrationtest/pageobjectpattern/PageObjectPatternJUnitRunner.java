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
    }
    @Test
    public void verifyProductLinkTest()
    {
        DashboardPage dashboardPage=new DashboardPage(driver);
        Assertions.assertTrue(dashboardPage.isProductLinkDisplayed());
    }
    @AfterAll
    public static void tearDown()
    {
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.logout();
        driver.quit();
    }
}
