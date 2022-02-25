package com.unitedcoder.integrationtest.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    WebDriver driver;
    @FindBy(linkText = "Customer List")
    WebElement customerListLink;
    @FindBy(linkText = "Add Customer")
    WebElement addCustomerLink;
    @FindBy(css = "img[rel='#customer_status']")
    WebElement customerStatusCheckBox;
    @FindBy(id="cust-firstname")
    WebElement customerFirstnameTextbox;
    @FindBy(id="cust-lastname")
    WebElement customerLastnameTextbox;
    @FindBy(name = "customer[email]")
    WebElement customerEmailTextbox;
    @FindBy(css = "input[value='Save']")
    WebElement saveButton;
    @FindBy(css = "div.success")
    WebElement customerSuccessMessageElement;
    int timeout=30;
    FunctionPage functionPage;

    public CustomerPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    //methods
    public boolean addCustomer(String firstname,String lastname,String emailAddress)
    {
        functionPage.waitUntilElementIsPresent(customerListLink,timeout);
        customerListLink.click();
        functionPage.waitUntilElementIsPresent(addCustomerLink,timeout);
        addCustomerLink.click();
        customerStatusCheckBox.click();
        customerFirstnameTextbox.sendKeys(firstname);
        customerLastnameTextbox.sendKeys(lastname);
        customerEmailTextbox.sendKeys(emailAddress);
        saveButton.click();
        functionPage.waitUntilElementIsPresent(customerSuccessMessageElement,timeout);

        boolean isCustomerAdded=customerSuccessMessageElement.isDisplayed();
        return isCustomerAdded;
    }

}
