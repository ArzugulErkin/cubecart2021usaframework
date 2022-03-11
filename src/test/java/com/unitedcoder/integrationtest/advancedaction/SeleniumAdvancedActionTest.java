package com.unitedcoder.integrationtest.advancedaction;

import com.unitedcoder.integrationtest.cubecarttestng.ScreenshotUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

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
    @Test
    public void menuTest()
    {
        driver.get("https://jqueryui.com/menu/");
        WebElement iframe=driver.findElement(By.cssSelector(".demo-frame"));
        functionPage.waitUntilElementIsPresent(iframe,30);
        driver.switchTo().frame(iframe);
        WebElement musicMenu=driver.findElement(By.id("ui-id-9"));
        //actions to mouse move
        Actions action=new Actions(driver);
        action.moveToElement(musicMenu).build().perform();
        functionPage.sleep(5);

        WebElement rockMenu=driver.findElement(By.id("ui-id-10"));
        action.moveToElement(rockMenu).build().perform();
        functionPage.sleep(5);
        //verification
        WebElement classicMenu=driver.findElement(By.id("ui-id-12"));
        functionPage.waitUntilElementIsPresent(classicMenu,30);
        Assert.assertTrue(classicMenu.isDisplayed());
    }
    @Test
    public void barnesNoblesMenuTest()
    {
        driver.get("https://www.barnesandnoble.com/");
        WebElement booksMenu=driver.findElement(By.linkText("Books"));
        functionPage.waitUntilElementIsPresent(booksMenu,30);
        //actions to mouse move
        Actions action=new Actions(driver);
        action.moveToElement(booksMenu).build().perform();
        functionPage.sleep(5);
        //verification
        WebElement bestSellers=driver.findElement(By.cssSelector("svg[alt='Bestsellers']"));
        functionPage.waitUntilElementIsPresent(bestSellers,30);
        Assert.assertTrue(bestSellers.isDisplayed());
    }
    @Test(description = "multiple windows test")
    public void multipleWindowsTest()
    {
        driver.get("http://www.seleniummastertutorial.com/");
        WebElement newWindowButton=driver.findElement(By.id("windowsButton"));
        functionPage.waitUntilElementIsPresent(newWindowButton,30);
        String mainWindowName=driver.getWindowHandle(); //this returns the name of the window
        System.out.println("Main window name: "+mainWindowName);
        newWindowButton.click();
        functionPage.sleep(5);
        Set<String> windows=driver.getWindowHandles(); //get all the windows
        for(String eachWindow:windows)
        {
            System.out.println("window name: "+eachWindow);
            if(!eachWindow.equalsIgnoreCase(mainWindowName))
            {
                driver.switchTo().window(eachWindow);
                WebElement buttonOnNewWindow=driver.findElement(By.linkText("Go back to Main Page"));
                functionPage.waitUntilElementIsPresent(buttonOnNewWindow,30);
                Assert.assertTrue(buttonOnNewWindow.isDisplayed());
            }
        }
    }
    @Test(description = "Alert accept test")
    public void alertAcceptTest()
    {
        driver.get("https://www.seleniummastertutorial.com/testfiles/alert.html");
        WebElement removeButton=driver.findElement(By.name("removebutton"));
        functionPage.waitUntilElementIsPresent(removeButton,30);
        removeButton.click();
        functionPage.sleep(5); //for demo purpose only
        //handle alert
        Alert alert=driver.switchTo().alert();
        String alertText=alert.getText();
        System.out.println(alertText);
        //accept the alert = clicking on the OK button
        alert.accept(); //this clicks OK button
        functionPage.sleep(5); //for demo purpose only
        //verification - verify that the element not Exist
        List<WebElement> testcase1=driver.findElements(By.id("testcase1"));
        int count=testcase1.size();
        Assert.assertTrue(count==0);
    }
    @Test(description = "Alert Dismiss test")
    public void alertDismissTest()
    {
        driver.get("https://www.seleniummastertutorial.com/testfiles/alert.html");
        WebElement removeButton=driver.findElement(By.name("removebutton"));
        functionPage.waitUntilElementIsPresent(removeButton,30);
        removeButton.click();
        functionPage.sleep(5); //for demo purpose only
        //handle alert
        Alert alert=driver.switchTo().alert();
        String alertText=alert.getText();
        System.out.println(alertText);
        //accept the alert = clicking on the OK button
        alert.dismiss(); //this clicks Cancel button
        functionPage.sleep(5); //for demo purpose only
        //verification - verify that the element Exist
        List<WebElement> testcase1=driver.findElements(By.id("testcase1"));
        int count=testcase1.size();
        Assert.assertTrue(count==1);
    }
    @Test(description = "Multiple links verification")
    public void multipleLinkTest()
    {
        driver.get("https://jqueryui.com/");
        //find all links under the sidebar
        List<WebElement> allLinks=driver.findElements(By.xpath("//div[@id='sidebar']//a"));
        int totalLinks= allLinks.size();
        System.out.println("Total links: "+totalLinks);
        List<String> urls=new ArrayList<>();
        for(WebElement link:allLinks)
        {
            String url=link.getAttribute("href");
            urls.add(url);
        }
        for(String eachUrl:urls)
        {
            driver.navigate().to(eachUrl);
            functionPage.sleep(2);
            ScreenshotUtility screenshotUtility=new ScreenshotUtility();
            screenshotUtility.captureImage(eachUrl.replace("http://jqueryui.com/","").
                    replaceAll("/",""),driver);
        }
        Assert.assertTrue(urls.size()>1);
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
