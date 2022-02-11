package com.unitedcoder.cubecartautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProduct {
    public static void main(String[] args) throws InterruptedException {
         Long currentTimeStamp=System.currentTimeMillis();  //get current time in Unix format
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");

        WebElement usernameInputBox = driver.findElement(By.id("username"));
        usernameInputBox.sendKeys("testautomation1");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys("automation123!");

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        //wait for logout button to display
        WebDriverWait wait = new WebDriverWait(driver, 30);  //
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav_products"))));

        //find the product link and click
        WebElement searchPlaceHolder = driver.findElement(By.id("search-placeholder"));
        searchPlaceHolder.click();
        WebDriverWait wait1=new WebDriverWait(driver,30);
        WebElement searchProductField=driver.findElement(By.name("search[product]"));
        wait1.until(ExpectedConditions.visibilityOf(searchProductField));

        int x = searchProductField.getRect().getX();
        int y = searchProductField.getRect().getY();
        searchProductField.sendKeys("Yellow");
        //Search a product
        //Create action object
        Actions actions = new Actions(driver);
        Thread.sleep(1000);
        //move mouse click
        actions.moveByOffset(x + 10,y + 30).click().build().perform();

        driver.findElement(By.xpath("//input[@value='Go']")).click();

        Thread.sleep(5000);


        //logout and close the browser
        //WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        //logoutIcon.click();
        driver.close();
        driver.quit();
    }
}
