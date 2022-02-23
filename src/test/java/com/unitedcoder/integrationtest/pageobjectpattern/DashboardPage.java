package com.unitedcoder.integrationtest.pageobjectpattern;

import org.openqa.selenium.PageLoadStrategy;
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
    @FindBy(linkText = "Customer List")
    WebElement customerListLink;
    @FindBy(linkText = "Categories")
    WebElement categoriesLink;
    @FindBy(id="nav_products")
    WebElement productsLink;
    @FindAll(
        @FindBy(xpath = "//div[@id='navigation']//a")
    )
    List<WebElement> allNavigationLinks;
    //create a constructor
    public DashboardPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public boolean isProductLinkDisplayed()
    {
        return productsLink.isDisplayed();
    }
    public void logout()
    {
        signOutIcon.click();
    }

}
