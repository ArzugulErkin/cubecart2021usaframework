@ApiTest
Feature: an authorized user should be able to manage customers and products using the cubecart api

  Scenario: an authorized user should be able to get all customers
    Given a valid username and password
    When the user sends a get request to the customer end point
    Then the api should return 200 response code
    And the api should return more than one customer

    Scenario: an authorized user should be able to get all products
      Given a valid username and password
      When the user sends a get request to the product end point
      Then the api should return 200 response code
      And the api should return more then one product

      Scenario Outline: an authorized user should be able to add multiple customers
        Given "<email>" and "<title>" and "<firstname>" and "<lastname>" and "<country>" and "<phone>" and "<status>" and "<language>" and "<ipaddress>"
        When the user sends a post request to the customer end point with the payload
        Then the api should return 200 response code and create a new customer

        Examples:
          |email  |title|firstname|lastname|country|phone|status|language|ipaddress|
          |mike.smith  |Mr|Mike|Smith|0|12345678|1|en-GB|111.222.333.444|
          |mary.jackson  |Mrs|Mary|Jackson|1|987654321|1|en-GB|10.1.1.10|


