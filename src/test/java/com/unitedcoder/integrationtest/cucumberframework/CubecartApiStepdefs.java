package com.unitedcoder.integrationtest.cucumberframework;

import com.unitedcoder.configutility.ApplicationConfig;
import com.unitedcoder.integrationtest.cubecartrestapi.PayloadUtility;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class CubecartApiStepdefs {
    Scenario scenario;
    String configFile="config-qa.properties";
    ApplicationConfig applicationConfig;
    String username;
    String password;
    String baseUrl;
    int port;
    String customerPayload;
    @Before
    public void beforeStepInCucumber(Scenario scenario)
    {
        applicationConfig=new ApplicationConfig();
        this.scenario=scenario;
        username = applicationConfig.readConfigProperties(configFile,"api.username");
        password=  applicationConfig.readConfigProperties(configFile,"api.password");
    }

    @Given("a valid username and password")
    public void aValidUsernameAndPassword() {
        scenario.log("api username "+ username);
        scenario.log("api password "+password);

    }

    @When("the user sends a get request to the customer end point")
    public void theUserSendsAGetRequestToTheCustomerEndPoint() {
        applicationConfig=new ApplicationConfig();
        port=Integer.parseInt(applicationConfig.readConfigProperties(configFile,"api.port"));
        baseUrl=applicationConfig.readConfigProperties(configFile,"api.baseurl");
        Response response= RestAssured.given().auth().basic(username,password).
                when().get(baseUrl+":"+port+"/customers");
        //check the status code
        System.out.println(response.getBody().prettyPrint());
        CucumberAPIResponseHolder.setCustomerResponseCode(response.getStatusCode());
        CucumberAPIResponseHolder.setTotalCustomers(response.jsonPath().getList("id").size());
    }

    @Then("the api should return {int} response code")
    public void theApiShouldReturnResponseCode(int arg0) {
        arg0=200;
        Assert.assertTrue(CucumberAPIResponseHolder.getCustomerResponseCode()==arg0);

    }

    @And("the api should return more than one customer")
    public void theApiShouldReturnMoreThanOneCustomer() {
        Assert.assertTrue(CucumberAPIResponseHolder.getTotalCustomers()>1);
    }

    @When("the user sends a get request to the product end point")
    public void theUserSendsAGetRequestToTheProductEndPoint() {
        applicationConfig=new ApplicationConfig();
        port=Integer.parseInt(applicationConfig.readConfigProperties(configFile,"api.port"));
        baseUrl=applicationConfig.readConfigProperties(configFile,"api.baseurl");
        Response response= RestAssured.given().auth().basic(username,password).
                when().get(baseUrl+":"+port+"/products");
        //check the status code
        System.out.println(response.getBody().prettyPrint());
        CucumberAPIResponseHolder.setProductResponseCode(response.getStatusCode());
        CucumberAPIResponseHolder.setTotalProducts(response.jsonPath().getList("id").size());
    }

    @And("the api should return more then one product")
    public void theApiShouldReturnMoreThenOneProduct() {
        Assert.assertTrue(CucumberAPIResponseHolder.getTotalProducts()>1);
    }
    @Given("<email> and <title> and <firstname> and <lastname> and <country> and <phone> and <status> and <language> and <ipaddress>")
    public void emailAndTitleAndFirstnameAndLastnameAndCountryAndPhoneAndStatusAndLanguageAndIpAddress(String arg0,String arg1,
                                                                                                       String arg2,String arg3,
                                                                                                       String arg4,String arg5,
                                                                                                       int arg6,String arg7,
                                                                                                       String arg8) {
        customerPayload= PayloadUtility.getCustomerPayload(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
        scenario.log(customerPayload);

    }


    @When("the user sends a post request to the customer end point with the payload")
    public void theUserSendsAPostRequestToTheCustomerEndPointWithThePayload() {

        Response response=RestAssured.given().headers("Content-Type","application/json").and()
                .body(customerPayload).auth().basic(username,password)
                .when().post(baseUrl+":"+port+"/customer").then().extract().response();
        //check the response content and response code
        System.out.println(response.getBody().prettyPrint());
        CucumberAPIResponseHolder.setAddCustomerResponseCode(response.getStatusCode());
        CucumberAPIResponseHolder.setNewCustomerId(response.jsonPath().getInt("id"));
        scenario.log(String.valueOf(response.jsonPath().getInt("id")));

    }

    @Then("the api should return {int} response code and create a new customer")
    public void theApiShouldReturnResponseCodeAndCreateANewCustomer(int arg0) {
        arg0=200;
       Assert.assertTrue(CucumberAPIResponseHolder.getAddCustomerResponseCode()==arg0);
       Assert.assertTrue(CucumberAPIResponseHolder.getNewCustomerId()>1);
    }
}
