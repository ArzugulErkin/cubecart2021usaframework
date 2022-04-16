package com.unitedcoder.integrationtest.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    WebDriver driver;
    @FindBy(css="i.fa.fa-sign-out")
    WebElement signOutIcon;

    @FindBy(id="nav_products")
    WebElement productsLink;
    @FindAll(
        @FindBy(xpath = "//div[@id='navigation']//a")
    )
    List<WebElement> allNavigationLinks;

    FunctionPage functionPage;
    int timeout=30;
    //create a constructor
    public DashboardPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    public boolean isProductLinkDisplayed()
    {
        functionPage.waitUntilElementIsPresent(productsLink,timeout);
        return productsLink.isDisplayed();
    }
    public void logout()
    {
        functionPage.waitUntilElementIsPresent(signOutIcon,timeout);
        signOutIcon.click();
    }

}
