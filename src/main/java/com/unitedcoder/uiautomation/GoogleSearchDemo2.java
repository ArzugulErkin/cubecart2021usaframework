package com.unitedcoder.uiautomation;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;

public class GoogleSearchDemo2 {
    public static void main(String[] args) throws InterruptedException {

        //define a scanner object
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please type a keyword to search on Google: ");
        String searchWord=scanner.nextLine();
        //add chromedriver reference to the system

        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get("https://www.google.com");
        //find the search field and type a search word
        WebElement searchBox=driver.findElement(By.name("q"));

        searchBox.sendKeys(searchWord + Keys.ENTER);
        Thread.sleep(5000); //sleep for 5 seconds
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
        driver.close();
        driver.quit();
    }
}
