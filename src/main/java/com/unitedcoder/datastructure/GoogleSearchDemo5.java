package com.unitedcoder.datastructure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearchDemo5 {
    public static void main(String[] args) throws InterruptedException {
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        List<String> cities=new ArrayList<>();
        cities.add("New York");
        cities.add("Toronto");
        cities.add("Washington DC");
        cities.add("Boston");
        cities.add("Chicago");
        cities.add("Waterloo");
        cities.add("Houston");
        //loop each city in the search
        for(String city: cities)
        {
            driver.get("https://www.google.com");
            WebElement searchBox=driver.findElement(By.name("q"));
            searchBox.sendKeys(city+ Keys.ENTER);
            Thread.sleep(5000); //sleep 5 seconds
            WebElement resultStatus=driver.findElement(By.id("result-stats"));
            if(resultStatus.isDisplayed())
            {
                System.out.println("Total search result is "+resultStatus.getText());
                System.out.println(city+ " search test passed");
            }
            else
                System.out.println(city+ "search failed");
        }
        driver.close();
        driver.quit();
    }
}
