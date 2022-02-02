package com.unitedcoder.excel;

import com.unitedcoder.datetime.LocalTimeDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerAutomation {
    public static void main(String[] args) throws InterruptedException {
        //read the username and password from the excel file
        ExcelUtility excelUtility=new ExcelUtility();
        String username=excelUtility.readExcelCell("doc\\cubecart-login.xlsx","Sheet1",1,0);
        String password=excelUtility.readExcelCell("doc\\cubecart-login.xlsx","Sheet1",1,1);

        //read the customer name from the excel file
        String customerFirstName=excelUtility.readExcelCell("doc\\cubecart-login.xlsx","Sheet2",2,0);
        String customerLastName=excelUtility.readExcelCell("doc\\cubecart-login.xlsx","Sheet2",2,1);
        String customerEmail=excelUtility.readExcelCell("doc\\cubecart-login.xlsx","Sheet2",2,2);

        // Long currentTimeStamp=System.currentTimeMillis();  //get current time in Unix format
        LocalTimeDemo localTimeDemo=new LocalTimeDemo();
        String currentTimeStamp=localTimeDemo.getLocalDateTime();
        //add chromedriver reference to the system
        System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");

        WebElement usernameInputBox = driver.findElement(By.id("username"));
        usernameInputBox.sendKeys(username);

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();
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
        customerFirstNameInputBox.sendKeys(customerFirstName+currentTimeStamp);

        WebElement customerLastNameInputBox = driver.findElement(By.id("cust-lastname"));
        customerLastNameInputBox.sendKeys(customerLastName+currentTimeStamp);

        WebElement customerEmailInputBox = driver.findElement(By.id("cust-email"));
        customerEmailInputBox.sendKeys("test"+currentTimeStamp+customerEmail);

        WebElement customerSaveButton = driver.findElement(By.name("save"));
        customerSaveButton.click();
        //verify the confirmation message
        WebElement confirmationMessage = driver.findElement(By.cssSelector("div.success"));
        System.out.println("Confirmation message display result: " + confirmationMessage.isDisplayed());

        //logout and close the browser
        WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        logoutIcon.click();
       driver.quit();
    }
}
