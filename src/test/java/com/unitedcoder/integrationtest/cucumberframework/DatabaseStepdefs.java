package com.unitedcoder.integrationtest.cucumberframework;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.integrationtest.database.ConnectionManager;
import com.unitedcoder.integrationtest.database.ConnectionType;
import com.unitedcoder.integrationtest.database.DataAccess;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.sql.Connection;

public class DatabaseStepdefs {
    private Scenario scenario;
    Connection connection=null;
    ApplicationConfig applicationConfig=new ApplicationConfig();
    final static String configFile="config-qa.properties";
    boolean isProductExistInTable=false;

    @Before
    public void beforeStepInCucumber(Scenario scenario)
    {
        this.scenario=scenario;
    }

    @Given("a user has read access to the cc_CubeCart_Inventory table")
    public void aUserHasReadAccessToTheCc_CubeCart_InventoryTable() {
        applicationConfig=new ApplicationConfig();
        String dbUrl=applicationConfig.readConfigProperties(configFile,"qa.dbUrl");
        String dbPort=applicationConfig.readConfigProperties(configFile,"qa.dbPort");
        String defaultDatabase=applicationConfig.readConfigProperties(configFile,"qa.defaultDatabase");
        String username=applicationConfig.readConfigProperties(configFile,"qa.username");
        String password=applicationConfig.readConfigProperties(configFile,"qa.password");
        connection= ConnectionManager.connectToDatabaseServer(dbUrl,dbPort,defaultDatabase,
                username,password, ConnectionType.MYSQL);
        scenario.log("Username "+username);
        scenario.log("Password "+ password);

    }
    @When("the user query the cc_CubeCart_Inventory table")
    public void theUserQueryTheCc_CubeCart_InventoryTable() {
        DataAccess dataAccess=new DataAccess();
        String productNameToSearch="ring1648586597662";
        scenario.log("Product to search: "+productNameToSearch);
        isProductExistInTable= dataAccess.getProductName(productNameToSearch,connection);
    }

    @Then("the user should see the product info")
    public void theUserShouldSeeTheProductInfo() {
        Assert.assertTrue(isProductExistInTable);
    }
}
