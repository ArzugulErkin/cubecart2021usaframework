@DatabaseTesting
Feature: user should be able to view product information in the cc_CubeCart_Inventory table
  Scenario: user should be able to get product info
    Given a user has read access to the cc_CubeCart_Inventory table
    When the user query the cc_CubeCart_Inventory table
    Then the user should see the product info