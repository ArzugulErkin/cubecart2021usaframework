package com.unitedcoder.inheritancetutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
   static WebDriver driver;
    public static void openBrowser()
    {
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");
    }
    public static void login(String username,String password)
    {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        usernameInputBox.sendKeys(username);
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        //wait for logout button to display
        WebDriverWait wait = new WebDriverWait(driver, 30);  //
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Customer List"))));
    }
    public static void logout()
    {
        WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        logoutIcon.click();
    }
    public static void closeBrowser()
    {
        //driver.close();
        driver.quit();
    }

}
