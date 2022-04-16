package com.unitedcoder.integrationtest.cubecartrestapi;

import com.unitedcoder.configutility.ApplicationConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CubecartApiRestLibraryTest {
  private static String baseUrl;
  private static int port;
  private static String username;
  private static String password;
  private static String configFile="config-qa.properties";
  @BeforeClass
  public void setUp()
  {
    ApplicationConfig applicationConfig=new ApplicationConfig();
    username=applicationConfig.readConfigProperties(configFile,"api.username");
    password=applicationConfig.readConfigProperties(configFile,"api.password");
    port=Integer.parseInt(applicationConfig.readConfigProperties(configFile,"api.port"));
    baseUrl=applicationConfig.readConfigProperties(configFile,"api.baseurl");
  }

  @Test(description = "authorized users should be able to get all customers")
  public void getAllCustomersTest()
  {
    //sending a request and get the response
    Response response= RestAssured.given().auth().basic(username,password).
            when().get(baseUrl+":"+port+"/customers");
    //check the status code
    System.out.println(response.getBody().prettyPrint());
    int responseCode=response.getStatusCode();
    Assert.assertEquals(responseCode,200);
  }
  @Test(description = "authorized users should be able to get all products")
  public void getAllProductsTest()
  {
    //sending a request and get the response
    Response response= RestAssured.given().auth().basic(username,password).
            when().get(baseUrl+":"+port+"/products");
    //check the status code
    System.out.println(response.getBody().prettyPrint());
    int responseCode=response.getStatusCode();
    Assert.assertEquals(responseCode,200);
  }
  @Test(description = "authorized users should be able to add a customer")
  public void addACustomerTest()
  {
    //define a request and response object
    Response response=RestAssured.given().headers("Content-Type","application/json").and()
            .body(PayloadUtility.getCustomerPayload()).auth().basic(username,password)
            .when().post(baseUrl+":"+port+"/customer").then().extract().response();
    //check the response content and response code
    System.out.println(response.getBody().prettyPrint());
    Assert.assertEquals(200,response.getStatusCode());
    Assert.assertTrue(response.jsonPath().getString("firstName").contains("Dolkun"));
  }
}
