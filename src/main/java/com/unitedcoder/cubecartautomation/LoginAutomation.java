package com.unitedcoder.cubecartautomation;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.configutility.ScreenshotUtility;
import com.unitedcoder.datetime.LocalTimeDemo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAutomation {
    public static void main(String[] args) throws InterruptedException {

        LocalTimeDemo localTimeDemo=new LocalTimeDemo();
        String currentTimeStamp=localTimeDemo.getLocalDateTime();
        //add chromedriver reference to the system
        // System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        //define a webdriver and chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window

        //read application config based on the environment variable
        ApplicationConfig applicationConfig=new ApplicationConfig();

        EnvironmentUtility environmentUtility=new EnvironmentUtility();

        String environmentName=System.getenv("environment").toUpperCase();

        String configFile=environmentUtility.getConfigFileByEnvironment(Environment.valueOf(environmentName));
        String url=applicationConfig.readConfigProperties(configFile,"url");
        String username=applicationConfig.readConfigProperties(configFile,"username");
        String password=applicationConfig.readConfigProperties(configFile,"password");

        //login
        {
            driver.get(url);
            WebElement usernameInputBox = driver.findElement(By.id("username"));
            usernameInputBox.sendKeys(username);
            WebElement passwordInputBox = driver.findElement(By.id("password"));
            passwordInputBox.sendKeys(password);
            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();
        }
        //take a screenshot
        String screenshotFolder=applicationConfig.readConfigProperties(configFile,"screenshot");
        ScreenshotUtility screenshotUtility=new ScreenshotUtility(driver);
        screenshotUtility.takeScreenshot(screenshotFolder,"login-"+environmentName+"-"+currentTimeStamp+".png");
        //wait for logout button to display
        WebDriverWait wait = new WebDriverWait(driver, 30);  //
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Customer List"))));
        Thread.sleep(5000);
        //log out
        //logout and close the browser
        WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        logoutIcon.click();
        driver.quit();
    }
}
