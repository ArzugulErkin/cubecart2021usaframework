package com.unitedcoder.uiautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchDemo4 {
  static   WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       driver=new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get("https://www.google.com");
        //find the search field and type a search word
        GoogleSearchDemo4 googleSearchDemo4=new GoogleSearchDemo4();
        googleSearchDemo4.searchAKeyword("New York");
        googleSearchDemo4.sleep(5);
        //verify the result
        WebElement result=driver.findElement(By.id("result-stats"));
        System.out.println("Result displayed? "+result.isDisplayed());
        //verify that search result is more than 1 million
        String searchResult=result.getText();
        System.out.println(searchResult);
        searchResult=searchResult.substring(0,searchResult.indexOf("("));
        System.out.println(searchResult);
        // About 6,350,000,000 results
        searchResult=searchResult.replace("About",""); //removing the About text
        searchResult=searchResult.replace("results",""); //removing results text
        searchResult=searchResult.replace(",","").replace(" ",""); //removing , sysmbol
        System.out.println("Total Search Count: "+searchResult);
        System.out.println(Long.parseLong(searchResult)>1000000);
        //close the browser and quit
        //driver.close();
        driver.quit();
    }
    public void waitUntilElementIsVisible(WebElement webElement)
    {
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public  void searchAKeyword(String keywordToSearch)
    {
        WebElement searchBox=driver.findElement(By.name("q"));
        waitUntilElementIsVisible(searchBox);
        searchBox.sendKeys(keywordToSearch+Keys.ENTER);
    }

    public  void sleep(int seconds)
    {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
