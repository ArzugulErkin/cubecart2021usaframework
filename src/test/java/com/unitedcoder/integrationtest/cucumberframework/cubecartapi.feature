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
        Given <email> and <title> and <firstname> and <lastname> and <country> and <phone> and <status> and <language> and <ip address>
        When the user sends a post request to the customer end point with the payload
        Then the api should return 200 response code and create a new customer

        Examples:
          |email  |title|firstname|lastname|country|phone|status|language|ip address|
          |mike.smith@test.com  |Mr|Mike|Smith|0|12345678|1|en-GB|11.22.33.44|
          |mary.jackson@test.com  |Mrs|Mary|Jackson|0|987654321|1|en-GB|10.1.1.10|


