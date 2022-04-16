package com.unitedcoder.integrationtest.cubecarttestng;

import com.unitedcoder.integrationtest.pageobjectpattern.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
 public WebDriver driver;
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

    public void setUpBrowserInHeadlessMode(String url)
    {
        System.out.println("Running the UI test in a headless browser mode");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");  //set up the browser in headless mode
        chromeOptions.addArguments("window-size=1200,1100"); //set up the browser virtual display size
        chromeOptions.addArguments("disable-gpu");  //disable graphic card
        driver = new ChromeDriver(chromeOptions);
        driver.get(url);
    }

    public void closeBrowser()
    {
        DashboardPage dashboardPage=new DashboardPage(driver);
        dashboardPage.logout();
        driver.quit();
    }

}
