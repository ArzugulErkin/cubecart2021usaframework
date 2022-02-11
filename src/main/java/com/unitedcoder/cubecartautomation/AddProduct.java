package com.unitedcoder.cubecartautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProduct {
    public static void main(String[] args) throws InterruptedException {
         Long currentTimeStamp=System.currentTimeMillis();  //get current time in Unix format
        //add chromedriver reference to the system
        //System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        //define a webdriver and chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");

        WebElement usernameInputBox = driver.findElement(By.id("username"));
        usernameInputBox.sendKeys("testautomation1");

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys("automation123!");

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        //wait for logout button to display
        WebDriverWait wait = new WebDriverWait(driver, 30);  //
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav_products"))));

        //find the product link and click
        WebElement productsLink = driver.findElement(By.id("nav_products"));
        productsLink.click();

        //find add product link and click
        WebElement addProductLink = driver.findElement(By.linkText("Add Product"));
        addProductLink.click();

        //fill out the new product form
        WebElement productNameInputBox=driver.findElement(By.id("name"));
        productNameInputBox.sendKeys("Apple Iphone "+currentTimeStamp);

        //select Apple as the manufacturer
        Select productFactorySelect=new Select(driver.findElement(By.id("manufacturer")));
        productFactorySelect.selectByVisibleText("Apple");

        WebElement productCodeInputBox=driver.findElement(By.id("product_code"));
        productCodeInputBox.sendKeys("Apple Iphone "+currentTimeStamp);

        //add categories
        WebElement categoryTabElement=driver.findElement(By.id("tab_category"));
        categoryTabElement.click();
        WebElement productCategory=driver.findElement(By.id("cat_35"));
        productCategory.click();

        WebElement productSaveButton=driver.findElement(By.cssSelector("input[value='Save']"));
        productSaveButton.click();


        //verify the confirmation message
        WebElement confirmationMessageElement = driver.findElement(By.cssSelector("div.success"));
        System.out.println("Confirmation message display result: " + confirmationMessageElement.isDisplayed());
        String confirmationText=confirmationMessageElement.getText(); //this will get the message
        String expectedMessage="Product successfully created";
        boolean verification=(confirmationText.contains(expectedMessage));
        System.out.println("Is the confirmation message accurate? "+verification);

        Thread.sleep(5000);
        //logout and close the browser
        WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        logoutIcon.click();
        driver.close();
        driver.quit();
    }
}
