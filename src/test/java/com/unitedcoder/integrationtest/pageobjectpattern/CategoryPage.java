package com.unitedcoder.integrationtest.pageobjectpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
    WebDriver driver;
    @FindBy(linkText = "Categories")
    WebElement categoriesLink;
    @FindBy(linkText = "Add Category")
    WebElement addCategoryLink;
    @FindBy(css="img[rel='#status']")
    WebElement statusCheckBox;
    @FindBy(css = "img[rel='#visible']")
    WebElement visibleCheckBox;
    @FindBy(name="cat[cat_name]")
    WebElement categoryNameTextBox;
    @FindBy(id="cat_save")
    WebElement saveButton;
    @FindBy(css="div.success")
    WebElement categoryConfirmationMessageElement;
    int timeout=30;
    FunctionPage functionPage;

    //initialize the page
    public CategoryPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        functionPage=new FunctionPage(driver);
    }
    //methods
    public boolean addNewCategory(String categoryName)
    {
        functionPage.waitUntilElementIsPresent(categoriesLink,timeout);
        categoriesLink.click();
        functionPage.waitUntilElementIsPresent(addCategoryLink,timeout);
        addCategoryLink.click();
        statusCheckBox.click();
        visibleCheckBox.click();
        categoryNameTextBox.sendKeys(categoryName);
        saveButton.click();
        functionPage.waitUntilElementIsPresent(categoryConfirmationMessageElement,timeout);
        return categoryConfirmationMessageElement.isDisplayed();

    }
    public String confirmationMessage()
    {
        WebElement confirmationMessageElement=driver.findElement(By.cssSelector("div.success"));
        return confirmationMessageElement.getText();
    }
}
