package com.unitedcoder.classtutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;


public class LoginAutomation {
    public static void main(String[] args) {
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window

        List<User> loginUsers=new ArrayList<>();
        loginUsers.add(new User("testautomation1","automation123!"));
        loginUsers.add(new User("testautomation1","automation123!"));
        loginUsers.add(new User("testautomation1","automation123!"));

       for(User user:loginUsers) {
         driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");
         WebElement usernameInputBox = driver.findElement(By.id("username"));
         usernameInputBox.sendKeys(user.getUsername());

         WebElement passwordInputBox = driver.findElement(By.id("password"));
         passwordInputBox.sendKeys(user.getPassword());

         WebElement loginButton = driver.findElement(By.id("login"));
         loginButton.click();
         //wait for logout button to display
         try {
             Thread.sleep(5000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         //logout and close the browser
         WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
         logoutIcon.click();
     }
        driver.close();
        driver.quit();
    }
}
