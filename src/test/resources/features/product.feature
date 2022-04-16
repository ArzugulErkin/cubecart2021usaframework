@UITesting
Feature: admin user can manage products
  as an admin, the user should be able to add, update or delete products

  @addProduct
  Scenario: admin user can add a new product
    Given admin user is on the dashboard page
    When the user fills out a new product form
    Then a new product should be created

    Scenario: admin user can delete an existing product
      Given admin user is on the dashboard page
      When the user tries to delete an existing product
      Then the product should be deleted