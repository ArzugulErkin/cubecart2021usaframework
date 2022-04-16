package com.unitedcoder.integrationtest.advancedaction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavaScriptExecutionTest {
    WebDriver driver;
    FunctionPage functionPage;
    @BeforeClass
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        functionPage=new FunctionPage(driver);
    }
    @Test
    public void javaScriptWindowScrollTest()
    {
        driver.get("https://jqueryui.com/");
        //define a javascript executor
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.location"); //returns current window location
        for(int i=0;i<10;i++)
        {
            javascriptExecutor.executeScript("window.scrollBy(0,100)");
            functionPage.sleep(2);
        }
        WebElement widgetLinkElement=driver.findElement(By.linkText("Widget Factory"));
        Assert.assertTrue(widgetLinkElement.isDisplayed());
    }
    @Test
    public void javaScriptClickTest()
    {
        driver.get("https://jqueryui.com/dialog/#animated");
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframe);
        //define the element
        WebElement openDialogButton=driver.findElement(By.id("opener"));
        JavascriptExecutor javascriptExecutor=(JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click()",openDialogButton);
        functionPage.sleep(5);
        WebElement dialogElement=driver.findElement(By.xpath("//span[text()='Basic dialog']"));
        Assert.assertTrue(dialogElement.isDisplayed());
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
