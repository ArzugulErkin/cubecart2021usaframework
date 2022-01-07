package com.unitedcoder.datastructure;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MultiSiteTestAutomation {
    public static void main(String[] args) throws InterruptedException {
        //define a map for website
        //Google(key)   value: https://www.google.com
        //Yahoo (key)   value: https://www.yahoo.com
        //Youtube (key)  value: https://www.YouTube.com
        //CNN (key)      value: https://www.cnn.com
        Map<String,String> websites=new HashMap<>();
        websites.put("Google","https://www.google.com"); //add an item to the map
        websites.put("Yahoo","https://www.yahoo.com");
        websites.put("YouTube","https://www.YouTube.com");
        websites.put("CNN","https://www.cnn.com");
        //define a web driver
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        //get all websites
        Set<String> sites=websites.keySet();
        for(String site: sites)
        {
            driver.get(websites.get(site));  //open the site
            if(driver.getTitle().contains(site))
                System.out.println(site+ " opened");
            Thread.sleep(5000);
        }
        //close the driver
        driver.close();
        driver.quit();

    }
}
