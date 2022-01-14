package com.unitedcoder.classtutorial;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchUsingObjectDemo2 {
    public static void main(String[] args) throws InterruptedException {
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        //define a list for the keywords
        List<Word> wordList=new ArrayList<>();
        Word word1=new Word();
        word1.setKeyword("Washington DC");
        Word word2=new Word();
        word2.setKeyword("Java Tutorial");
        Word word3=new Word();
        word3.setKeyword("Test Automation Tutorial");
        wordList.add(word1);
        wordList.add(word2);
        wordList.add(word3);
        wordList.add(new Word(".Net Tutorial"));
        wordList.add(new Word("Python Tutorial"));
        wordList.add(new Word("fdlfjdklfjda;jfdalf;dalfjdsal"));
        wordList.add(new Word("New York"));
        wordList.add(new Word("Toronto,CA"));

        for(Word keyword:wordList)
        {
            driver.get("https://www.google.com");
            WebElement searchBox=driver.findElement(By.name("q"));
            searchBox.sendKeys(keyword.getKeyword()+Keys.ENTER);
            Thread.sleep(5000);
            List<WebElement> resultElements=driver.findElements(By.id("result-stats"));
            if(resultElements.size()>0) {
                System.out.println(keyword.getKeyword() + "  search passed");
                String searchResultText=resultElements.get(0).getText();
                System.out.println("Search result : "+searchResultText);
            }
            else
                System.out.println(keyword.getKeyword()+ "  search failed");
        }
        driver.close();
        driver.quit();
    }
}
