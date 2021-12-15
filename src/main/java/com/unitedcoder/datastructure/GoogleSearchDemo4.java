package com.unitedcoder.datastructure;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchDemo4 {
    public static void main(String[] args) throws InterruptedException {
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        String[] websites=new String[5];
        websites[0]="https://www.google.com";
        websites[1]="https://www.yahoo.com";
        websites[2]="https://www.amazon.com";
        websites[3]="https://www.youtube.com";
        websites[4]="https://www.walmart.com";

        //loop each website
        for(String website: websites)
        {
            driver.get(website);
            String websiteTitle=driver.getTitle(); // get the title of the website
            System.out.println(websiteTitle);
            String siteName=website.replace("https://www.","").replace(".com","");
            if(websiteTitle.toLowerCase().contains(siteName))
                System.out.println("Site verification passed");
            else
            {
                System.out.println("Site verification failed");
            }
            Thread.sleep(5000); //sleep 5 seconds
        }
        driver.close();
        driver.quit();

    }
}
