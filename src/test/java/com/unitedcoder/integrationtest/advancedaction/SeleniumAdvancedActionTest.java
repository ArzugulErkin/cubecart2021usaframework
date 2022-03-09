package com.unitedcoder.integrationtest.advancedaction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumAdvancedActionTest {
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
    public void dragDropTest()
    {
        driver.get("https://jqueryui.com/droppable/");
        WebElement iframe=driver.findElement(By.tagName("iframe"));
        //switch to the iframe
        driver.switchTo().frame(iframe);
        WebElement draggableElement=driver.findElement(By.id("draggable"));
        WebElement droppableElement=driver.findElement(By.id("droppable"));
        //define drag and drop action
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(draggableElement,10,0).
                dragAndDropBy(draggableElement,10,0).
                dragAndDrop(draggableElement,droppableElement).build().perform();
        functionPage.sleep(5);
        //assertion
        Assert.assertTrue(droppableElement.getText().contains("Dropped"));
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
