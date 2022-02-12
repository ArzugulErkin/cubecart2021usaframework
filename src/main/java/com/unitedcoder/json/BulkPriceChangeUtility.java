package com.unitedcoder.json;

import com.unitedcoder.json.Product;
import com.unitedcoder.json.ProductPriceChangeAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BulkPriceChangeUtility {
    WebDriver driver;
    public boolean priceChange(List<Product> products, ProductPriceChangeAction productPriceChangeAction,
                            double amount) {

        //check products to update
        for(Product product:products)
        {
            String productCheckbox=String.format("//td[text()='%s']/preceding-sibling::td/div/input[@class='products']",product.getProductName());
            WebDriverWait wait=new WebDriverWait(driver,30);
            WebElement eachProductCheckBox=driver.findElement(By.xpath(productCheckbox));
            wait.until(ExpectedConditions.visibilityOf(eachProductCheckBox));
            eachProductCheckBox.click();
        }
        WebElement bulkPriceActionDropdownList = driver.findElement(By.id("bulk_price_action"));
        Select bulkPriceActionSelect = new Select(bulkPriceActionDropdownList);
        switch (productPriceChangeAction) {
            case ADD:
                bulkPriceActionSelect.selectByVisibleText("Add");
                break;
            case SUBTRACT:
                bulkPriceActionSelect.selectByVisibleText("Subtract");
                break;
            case SETTO:
                bulkPriceActionSelect.selectByVisibleText("Set to");
                break;
            default:
                bulkPriceActionSelect.selectByVisibleText("Set to");
                break;
        }
        //set input amount
        WebElement inputAmountTextBox=driver.findElement(By.name("price[value]"));
        inputAmountTextBox.sendKeys(String.valueOf(amount));

        WebElement saveButton = driver.findElement(By.cssSelector("input[value='Save']"));
        saveButton.click();
        WebElement successMessageElement=driver.findElement(By.cssSelector("div.success"));
        if(successMessageElement.getText().contains("updated"))
            return true;
        else
            return false;
    }
}
