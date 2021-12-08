package com.unitedcoder.uiautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchDemo3 {
    public static void main(String[] args) throws InterruptedException {

        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        String[] cities=new String[]{"Washington DC","New York","Boston","Chicago"};
        for(int i=0;i<=cities.length-1;i++) {
            driver.get("https://www.google.com");
            //find the search field and type a search word
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(cities[i] + Keys.ENTER);
            Thread.sleep(5000); //sleep for 5 seconds
            //verify the result
            //WebElement result = driver.findElement(By.id("result-stats"));
            //System.out.println("Result displayed? " + result.isDisplayed());
        }
        driver.close();
        driver.quit();
    }
}
