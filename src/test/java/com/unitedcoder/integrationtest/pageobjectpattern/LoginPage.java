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

    //create constructor to initialize the page
  public LoginPage(WebDriver driver)
  {
      this.driver=driver;
      PageFactory.initElements(driver,this);  //initialize all elements defined on this page
  }
  //define action
    public void enterUsername(String username)
    {
        usernameTextbox.sendKeys(username);
    }
    public void enterPassword(String password)
    {
        passwordTextbox.sendKeys(password);
    }
    public void clickLoginButton()
    {
        loginButton.click();
    }
    public void login(String username,String password)
    {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

}
