package com.unitedcoder.integrationtest.pageobjectpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(id="username")
    WebElement usernameTextbox;
    @FindBy(id="password")
    WebElement passwordTextbox;
    @FindBy(id="login")
    WebElement loginButton;
    FunctionPage functionPage;
    int timeout=30;

    //create constructor to initialize the page
  public LoginPage(WebDriver driver)
  {
      this.driver=driver;
      PageFactory.initElements(driver,this);  //initialize all elements defined on this page
      functionPage=new FunctionPage(driver);
  }
  //define action
    public void enterUsername(String username)
    {
        functionPage.waitUntilElementIsPresent(usernameTextbox,timeout);
        usernameTextbox.sendKeys(username);
    }
    public void enterPassword(String password)
    {
        functionPage.waitUntilElementIsPresent(passwordTextbox,timeout);
        passwordTextbox.sendKeys(password);
    }
    public void clickLoginButton()
    {
        functionPage.waitUntilElementIsPresent(loginButton,timeout);
        loginButton.click();
    }
    public void login(String username,String password)
    {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

}
