package com.unitedcoder.inheritancetutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddCustomerAutomation extends BaseClass{
    public static void main(String[] args) {
        openBrowser();
        login("testautomation1","automation123!");
        addCustomerTest("Manizha","Manizha","manizhat");
        logout();
        closeBrowser();

    }
    public  static boolean addCustomerTest(String firstName,String lastName,String emailPrefix)
    {
        Long currentTimeStamp=System.currentTimeMillis();
        WebElement customerLink = driver.findElement(By.linkText("Customer List"));
        customerLink.click();
        //find add customer link and click
        WebElement addCustomerLink = driver.findElement(By.linkText("Add Customer"));
        addCustomerLink.click();
        //fill out the new customer form
        WebElement customerStatusCheckbox = driver.findElement(By.cssSelector("img.checkbox.cbs"));
        customerStatusCheckbox.click();
        WebElement customerFirstNameInputBox = driver.findElement(By.id("cust-firstname"));
        customerFirstNameInputBox.sendKeys(firstName+currentTimeStamp);
        WebElement customerLastNameInputBox = driver.findElement(By.id("cust-lastname"));
        customerLastNameInputBox.sendKeys(lastName+currentTimeStamp);
        WebElement customerEmailInputBox = driver.findElement(By.id("cust-email"));
        customerEmailInputBox.sendKeys(emailPrefix+currentTimeStamp+"@test.com");
        WebElement customerSaveButton = driver.findElement(By.name("save"));
        customerSaveButton.click();
        //verify the confirmation message
        WebElement confirmationMessage = driver.findElement(By.cssSelector("div.success"));
        if(confirmationMessage.isDisplayed()) {
            System.out.println("add customer test passed");
            return true;
        }
        else
        {
            System.out.println("add customer test failed");
            return false;
        }
    }
}
