package com.unitedcoder.integrationtest.cucumberframework;

public class CucumberAPIResponseHolder {
  private static int customerResponseCode;
 private   static int totalCustomers;
 private static   int productResponseCode;
 private   static int totalProducts;
 private static int addCustomerResponseCode;
 private static int newCustomerId;

    public static int getNewCustomerId() {
        return newCustomerId;
    }

    public static void setNewCustomerId(int newCustomerId) {
        CucumberAPIResponseHolder.newCustomerId = newCustomerId;
    }

    public static int getAddCustomerResponseCode() {
        return addCustomerResponseCode;
    }

    public static void setAddCustomerResponseCode(int addCustomerResponseCode) {
        CucumberAPIResponseHolder.addCustomerResponseCode = addCustomerResponseCode;
    }

    public static int getCustomerResponseCode() {
        return customerResponseCode;
    }

    public static void setCustomerResponseCode(int customerResponseCode) {
        CucumberAPIResponseHolder.customerResponseCode = customerResponseCode;
    }

    public static int getTotalCustomers() {
        return totalCustomers;
    }

    public static void setTotalCustomers(int totalCustomers) {
        CucumberAPIResponseHolder.totalCustomers = totalCustomers;
    }

    public static int getProductResponseCode() {
        return productResponseCode;
    }

    public static void setProductResponseCode(int productResponseCode) {
        CucumberAPIResponseHolder.productResponseCode = productResponseCode;
    }

    public static int getTotalProducts() {
        return totalProducts;
    }

    public static void setTotalProducts(int totalProducts) {
        CucumberAPIResponseHolder.totalProducts = totalProducts;
    }
}
