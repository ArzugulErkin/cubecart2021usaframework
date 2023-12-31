package com.unitedcoder.cubecartautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerArrayAutomation2 {
    public static void main(String[] args) throws InterruptedException {
        //define test data for login and customer using array
        String[] loginUser = new String[]{"testautomation1", "automation123!"}; //loginUser[0], loginUser[1]
        String[][] customers = new String[][]
                {
                        {"Mike", "Smith", "mike.smith@test.com","123-456-1234"},
                        {"Mary", "Smith", "mary.smith@test.com","223-987-1234"},
                        {"Jason", "Jackson", "jason.jackson@test.com","661-234-986"},
                        {"Dilmurat","Mutellip","dilmurat.mutellip@test.com","981-123-4321"}
                };
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
        usernameInputBox.sendKeys(loginUser[0]);

        WebElement passwordInputBox = driver.findElement(By.id("password"));
        passwordInputBox.sendKeys(loginUser[1]);

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        //wait for logout button to display
        WebDriverWait wait = new WebDriverWait(driver, 30);  //
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Customer List"))));
        //find the customer link and click
        WebElement customerLink = driver.findElement(By.linkText("Customer List"));
        customerLink.click();
        int totalCustomers=customers.length;
        for(int i=0;i<totalCustomers;i++) {
            //find add customer link and click
            String firstName=customers[i][0];
            String lastName=customers[i][1];
            String email=customers[i][2];
            String phone=customers[i][3];

            WebElement addCustomerLink = driver.findElement(By.linkText("Add Customer"));
            addCustomerLink.click();
            //fill out the new customer form
            WebElement customerStatusCheckbox = driver.findElement(By.cssSelector("img.checkbox.cbs"));
            customerStatusCheckbox.click();
            WebElement customerFirstNameInputBox = driver.findElement(By.id("cust-firstname"));
            customerFirstNameInputBox.sendKeys(firstName + currentTimeStamp);
            WebElement customerLastNameInputBox = driver.findElement(By.id("cust-lastname"));
            customerLastNameInputBox.sendKeys(lastName + currentTimeStamp);
            WebElement customerEmailInputBox = driver.findElement(By.id("cust-email"));
            customerEmailInputBox.sendKeys("test" + currentTimeStamp + email);
            WebElement customerPhoneInputBox=driver.findElement(By.id("cust-phone"));
            customerPhoneInputBox.sendKeys(phone);

            WebElement customerSaveButton = driver.findElement(By.name("save"));
            customerSaveButton.click();
            //verify the confirmation message
            WebElement confirmationMessage = driver.findElement(By.cssSelector("div.success"));
            System.out.println("Confirmation message display result: " + confirmationMessage.isDisplayed());
            System.out.println(String.format("%s %s %s is added",firstName,lastName,email));
            Thread.sleep(5000);
        }
        //logout and close the browser
        WebElement logoutIcon = driver.findElement(By.cssSelector("i.fa.fa-sign-out"));
        logoutIcon.click();
        driver.close();
        driver.quit();
    }
}
