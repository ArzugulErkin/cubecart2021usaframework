package com.unitedcoder.json;

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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FunctionLibrary {
    WebDriver driver;
    public  void openBrowser()
    {
        //add chromedriver reference to the system
        //System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
       driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");
    }
    public  void login(LoginUser loginUser)
    {
        WebElement usernameInputBox = driver.findElement(By.id("username"));
        usernameInputBox.sendKeys(loginUser.getName());
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys(loginUser.getPassword());
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
        //wait for logout button to display
        WebDriverWait wait = new WebDriverWait(driver, 30);  //
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Customer List"))));
    }
    public  void logout()
    {
        WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        logoutIcon.click();
    }

    public  boolean addCustomer(Customer customer)
    {
        //wait for logout button to display
        WebDriverWait wait = new WebDriverWait(driver, 30);  //
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Customer List"))));
        //find the customer link and click
        WebElement customerLink = driver.findElement(By.linkText("Customer List"));
        customerLink.click();
        //find add customer link and click
        WebElement addCustomerLink = driver.findElement(By.linkText("Add Customer"));
        addCustomerLink.click();
        //fill out the new customer form
        WebElement customerStatusCheckbox = driver.findElement(By.cssSelector("img.checkbox.cbs"));
        customerStatusCheckbox.click();
        WebElement customerFirstNameInputBox = driver.findElement(By.id("cust-firstname"));
        customerFirstNameInputBox.sendKeys(customer.getFirstName()+getCurrentTimestamp());
        WebElement customerLastNameInputBox = driver.findElement(By.id("cust-lastname"));
        customerLastNameInputBox.sendKeys(customer.getLastName()+getCurrentTimestamp());
        WebElement customerEmailInputBox = driver.findElement(By.id("cust-email"));
        customerEmailInputBox.sendKeys("test"+getCurrentTimestamp()+customer.getEmail());
        WebElement customerSaveButton = driver.findElement(By.name("save"));
        customerSaveButton.click();
        //verify the confirmation message
        WebElement confirmationMessage = driver.findElement(By.cssSelector("div.success"));
        System.out.println("Confirmation message display result for customer: " + confirmationMessage.isDisplayed());
        if(confirmationMessage.isDisplayed())
            return true;
        else
            return false;
    }
    public  boolean addProduct(Product product)
    {
        //find add product link and click
        WebElement productsLink = driver.findElement(By.id("nav_products"));
        productsLink.click();

        WebElement addProductLink = driver.findElement(By.linkText("Add Product"));
        addProductLink.click();

        //fill out the new product form
        WebElement productNameInputBox=driver.findElement(By.id("name"));
        productNameInputBox.sendKeys(product.getProductName()+getCurrentTimestamp());

        //select Apple as the manufacturer
        Select productFactorySelect=new Select(driver.findElement(By.id("manufacturer")));
        productFactorySelect.selectByVisibleText("Apple");

        WebElement productCodeInputBox=driver.findElement(By.id("product_code"));
        productCodeInputBox.sendKeys(product.getProductCode()+getCurrentTimestamp());
        //add categories
        WebElement categoryTabElement=driver.findElement(By.id("tab_category"));
        categoryTabElement.click();
        WebElement productCategory=driver.findElement(By.id(product.getProductCategory()));
        productCategory.click();
        WebElement productSaveButton=driver.findElement(By.cssSelector("input[value='Save']"));
        productSaveButton.click();
        //verify the confirmation message
        WebElement confirmationMessageElement = driver.findElement(By.cssSelector("div.success"));
        System.out.println("Confirmation message display result for Product: " + confirmationMessageElement.isDisplayed());
        if(confirmationMessageElement.isDisplayed())
            return true;
        else
            return false;
    }

    public String getCurrentTimestamp()
    {
        LocalDateTime now=LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        return now.format(formatter);
    }
    public void closeBrowser()
    {
        //driver.close();
        driver.quit();
    }

}
