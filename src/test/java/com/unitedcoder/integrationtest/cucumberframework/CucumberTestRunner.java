package com.unitedcoder.integrationtest.cucumberframework;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.integrationtest.pageobjectpattern.DashboardPage;
import com.unitedcoder.integrationtest.pageobjectpattern.LoginPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber-output/cubecart-ui-cucumber.html"},
features = {"classpath:features/product.feature"})

public class CucumberTestRunner {

 static WebDriver driver;
 final static String configFile="config-qa.properties";
 static ApplicationConfig applicationConfig;
 public static WebDriver getDriver()
 {
     return driver;
 }
 @BeforeClass
    public static void setUp()
 {
     applicationConfig=new ApplicationConfig();
     String url=applicationConfig.readConfigProperties(configFile,"url");
     int isHeadless=Integer.parseInt(applicationConfig.readConfigProperties(configFile,"headless"));
     WebDriverManager.chromedriver().setup();
     ChromeOptions chromeOptions=new ChromeOptions();
     if(isHeadless==1)
     {
         chromeOptions.addArguments("headless");  //set up the browser in headless mode
         chromeOptions.addArguments("window-size=1200,1100"); //set up the browser virtual display size
         chromeOptions.addArguments("disable-gpu");  //disable graphic card
         driver=new ChromeDriver(chromeOptions);
     }
     else
     {
       chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       driver=new ChromeDriver(chromeOptions);
       driver.manage().window().maximize();
     }
     driver.get(url);
     LoginPage loginPage=new LoginPage(driver);
     applicationConfig=new ApplicationConfig();
     String username=applicationConfig.readConfigProperties(configFile,"username");
     String password=applicationConfig.readConfigProperties(configFile,"password");
     loginPage.login(username,password);
 }

 @AfterClass
    public static void tearDown()
 {
     DashboardPage dashboardPage=new DashboardPage(driver);
     dashboardPage.logout();
     driver.quit();
 }

}
