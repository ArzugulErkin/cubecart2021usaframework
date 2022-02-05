package com.unitedcoder.configutility;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GoogleSearchScreenshot {
    public static void main(String[] args) throws InterruptedException {

        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        String[] cities=new String[]{"Washington DC","New York","Boston","Chicago","Turkey"};
        ApplicationConfig applicationConfig=new ApplicationConfig();
        String imageFolder=applicationConfig.readConfigProperties("config-qa.properties","screenshot");
        ScreenshotUtility screenshotUtility=new ScreenshotUtility(driver);
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        String timestamp=localDateTime.format(formatter);
        for(int i=0;i<=cities.length-1;i++) {
            driver.get("https://www.google.com");
            //find the search field and type a search word
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(cities[i] + Keys.ENTER);
            Thread.sleep(2000); //sleep for 5 seconds
            screenshotUtility.takeScreenshot(imageFolder,"city-"+cities[i].trim()+timestamp+".png");
            //verify the result
            //WebElement result = driver.findElement(By.id("result-stats"));
            //System.out.println("Result displayed? " + result.isDisplayed());
        }
        driver.quit();
    }
}
