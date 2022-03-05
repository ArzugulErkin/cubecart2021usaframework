package com.unitedcoder.integrationtest.cubecarttestng;

import com.unitedcoder.integrationtest.pageobjectpattern.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    WebDriver driver;
    public void setUpBrowser(String url)
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get(url);
    }
    public void closeBrowser()
    {
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.logout();
        driver.quit();
    }

}
