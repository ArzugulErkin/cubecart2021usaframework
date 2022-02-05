package com.unitedcoder.configutility;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginDemo {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        String configFile="config-qa.properties";
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        String testUrl=applicationConfig.readConfigProperties(configFile,"url");
        driver.get(testUrl);
        String testUsername=applicationConfig.readConfigProperties(configFile,"username");
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        usernameInputBox.sendKeys(testUsername);

        String testPassword=applicationConfig.readConfigProperties(configFile,"password");
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys(testPassword);

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        //wait for logout button to display
        long timeout=Long.parseLong(applicationConfig.readConfigProperties(configFile,"timeout"));

        WebDriverWait wait = new WebDriverWait(driver, timeout);  //
      WebElement customerListElement= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Customer List"))));
      String screenshotFolder=applicationConfig.readConfigProperties(configFile,"screenshot");

      ScreenshotUtility screenshotUtility=new ScreenshotUtility(driver);

      if(customerListElement.isDisplayed())
      {
          screenshotUtility.takeScreenshot(screenshotFolder,"login-test-pass"+System.currentTimeMillis()+".png");
          System.out.println("Login test successful");
          WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
          logoutIcon.click();
      }
        else
      {
          System.out.println("Login test failed");
          screenshotUtility.takeScreenshot(screenshotFolder,"login-test-fail"+System.currentTimeMillis()+".png");
      }
        driver.quit();
    }
}
