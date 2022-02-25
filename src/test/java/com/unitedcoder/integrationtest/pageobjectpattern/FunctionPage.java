package com.unitedcoder.integrationtest.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FunctionPage {
    WebDriver driver;
    public FunctionPage(WebDriver driver)
    {
        this.driver=driver;
    }

    //add a sleep method
    public void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //wait until element is present
    public void waitUntilElementIsPresent(WebElement element,int timeout)
    {
        WebDriverWait webDriverWait=new WebDriverWait(driver,timeout);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }
    //wait until an alert is displayed
    public void waitUntilAlertIsPresent(int timeout)
    {
        WebDriverWait webDriverWait=new WebDriverWait(driver,timeout);
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }
    public String getCurrentTimestampWithoutDash()
    {
        LocalDateTime now=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        return now.format(formatter);
    }
}
