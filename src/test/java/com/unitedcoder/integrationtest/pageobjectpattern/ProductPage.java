package com.unitedcoder.integrationtest.pageobjectpattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
    //define webdriver
    WebDriver driver;
    @FindBy(id = "nav_products")
    WebElement productLinkText;
    //add product link
    @FindBy(linkText = "Add Product")
    WebElement addProductLink;
    @FindBy(css = "img.checkbox.cbs")
    WebElement addProductsStatusCheckBox;
    @FindBy(id = "name")
    WebElement productNameInputBox;
    @FindBy(id = "manufacturer")
    WebElement productManufactureDropDownList;
    @FindBy(id = "condition")
    WebElement conditionDropdownList;
    @FindBy(id = "product_code")
    WebElement productCodeInputBox;
    @FindBy(id= "product_weight")
    WebElement productWeightInputBox;
    @FindBy(id = "product_height")
    WebElement productHeightInputBox;
    @FindBy(css = "input[value='Save']")
    WebElement productSaveButton;
    @FindBy(css = "div.success")
    WebElement productSuccessMessageElement;
    @FindBy(linkText = "View All")
    WebElement viewAllLink;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //method to add product
    public boolean addProduct(String productName, String productCode, String manufacture,
                              String condition,int weight, int height) {
        productLinkText.click();
        addProductLink.click();
        addProductsStatusCheckBox.click();
        productNameInputBox.sendKeys(productName);
        productCodeInputBox.sendKeys(productCode);

        Select manufacturerSelect = new Select(productManufactureDropDownList);
        manufacturerSelect.selectByVisibleText(manufacture);

        Select conditionSelect = new Select(conditionDropdownList);
        conditionSelect.selectByVisibleText(condition);
        productWeightInputBox.sendKeys(String.valueOf(weight));
        productHeightInputBox.sendKeys(String.valueOf(height));
        productSaveButton.click();
        boolean isProductAdded = productSuccessMessageElement.isDisplayed();
        return isProductAdded;
    }
    //method for deleting a product
    public boolean deleteProduct(String productName)
    {
        productLinkText.click();
        viewAllLink.click();
        String productXpathToDelete=String.format("//tr/td/a[text()='%s']/following::td/a/i[@class='fa fa-trash']",productName);
        WebElement productToDelete=driver.findElement(By.xpath(productXpathToDelete));
        productToDelete.click();
        Alert alert=driver.switchTo().alert();
        String alertText=alert.getText();
        System.out.println(alertText);
        //accept the alert
        alert.accept();
        String deleteMessage=productSuccessMessageElement.getText();
        if(deleteMessage.contains("deleted"))
            return true;
        else
            return false;

    }

}
