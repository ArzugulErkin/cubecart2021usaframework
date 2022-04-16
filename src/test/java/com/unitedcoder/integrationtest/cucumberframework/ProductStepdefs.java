package com.unitedcoder.integrationtest.cucumberframework;

import com.unitedcoder.integrationtest.database.TestDataHolder;
import com.unitedcoder.integrationtest.pageobjectpattern.DashboardPage;
import com.unitedcoder.integrationtest.pageobjectpattern.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductStepdefs {
    WebDriver driver=CucumberTestRunner.getDriver(); //use the driver from the Cucumber Test Runner class
    ProductPage productPage;
    DashboardPage dashboardPage;
    boolean isProductAdded=false;
    boolean isProductDelete=false;


    @Given("admin user is on the dashboard page")
    public void adminUserIsOnTheDashboardPage() {
        dashboardPage=new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isProductLinkDisplayed());
    }

    @When("the user fills out a new product form")
    public void theUserFillsOutANewProductForm() {
        productPage=new ProductPage(driver);
        long timestamp=System.currentTimeMillis();
       String productName="iphone12_"+timestamp;
       TestDataHolder.setProductName(productName);
      isProductAdded=  productPage.addProduct(productName,"iphone12_"+timestamp,"Apple",
                "New",100,10);
    }

    @Then("a new product should be created")
    public void aNewProductShouldBeCreated() {
        Assert.assertTrue(isProductAdded);
    }

    @When("the user tries to delete an existing product")
    public void theUserTriesToDeleteAnExistingProduct() {
        productPage=new ProductPage(driver);
       isProductDelete= productPage.deleteProduct(TestDataHolder.getProductName());
    }

    @Then("the product should be deleted")
    public void theProductShouldBeDeleted() {
        Assert.assertTrue(isProductDelete);
    }
}
