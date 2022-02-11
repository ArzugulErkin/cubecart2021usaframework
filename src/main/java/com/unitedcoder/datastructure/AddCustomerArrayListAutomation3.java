package com.unitedcoder.datastructure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AddCustomerArrayListAutomation3 {
    public static void main(String[] args) throws InterruptedException {
        //define test data for login and customer using arrayList
        List<String> loginUsers=new ArrayList<>();
        loginUsers.add("testautomation1");
        loginUsers.add("automation123!");

        //comma separated value , comma delimited values
        List<String> customers=new ArrayList<>();
        customers.add("Mike,Smith,mike.smith@test.com,123-456-1234");
        customers.add("Mary,Smith,mary.smith@test.com,223-987-1234");
        customers.add("Jason,Jackson,jason.jackson@test.com,661-234-986");
        //add chromedriver reference to the system
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "c:\\webdriver\\chromedriver.exe");
        //define a webdriver and chrome options
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        //open the browser
        driver.manage().window().maximize(); //maximize the browser window
        driver.get("http://cubecartqa1.unitedcoderschool.com/admin_xrmx7f.php");

        WebElement usernameInputBox = driver.findElement(By.id("username"));
        usernameInputBox.sendKeys(loginUsers.get(0));

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys(loginUsers.get(1));

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        //wait for logout button to display
        WebDriverWait wait = new WebDriverWait(driver, 30);  //
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Customer List"))));
        //find the customer link and click
        WebElement customerLink = driver.findElement(By.linkText("Customer List"));
        customerLink.click();
        int totalCustomers=customers.size(); //this will return total customers
        for(String customer: customers) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            String timeStamp=dtf.format(now);
            String[] eachCustomer=customer.split(",");
            WebElement addCustomerLink = driver.findElement(By.linkText("Add Customer"));
            addCustomerLink.click();
            //fill out the new customer form
            WebElement customerStatusCheckbox = driver.findElement(By.cssSelector("img.checkbox.cbs"));
            customerStatusCheckbox.click();
            WebElement customerFirstNameInputBox = driver.findElement(By.id("cust-firstname"));
            customerFirstNameInputBox.sendKeys(eachCustomer[0] + timeStamp);
            WebElement customerLastNameInputBox = driver.findElement(By.id("cust-lastname"));
            customerLastNameInputBox.sendKeys(eachCustomer[1] + timeStamp);
            WebElement customerEmailInputBox = driver.findElement(By.id("cust-email"));
            customerEmailInputBox.sendKeys("test" +timeStamp + eachCustomer[2]);
            WebElement customerPhoneInputBox=driver.findElement(By.id("cust-phone"));
            customerPhoneInputBox.sendKeys(eachCustomer[3]);

            WebElement customerSaveButton = driver.findElement(By.name("save"));
            customerSaveButton.click();
            //verify the confirmation message
            WebElement confirmationMessage = driver.findElement(By.cssSelector("div.success"));
            System.out.println("Confirmation message display result: " + confirmationMessage.isDisplayed());
            System.out.println(String.format("%s %s %s is added",eachCustomer[0],eachCustomer[1],eachCustomer[3]));
            Thread.sleep(5000);
        }
        //logout and close the browser
        WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        logoutIcon.click();
        driver.close();
        driver.quit();
    }
}
