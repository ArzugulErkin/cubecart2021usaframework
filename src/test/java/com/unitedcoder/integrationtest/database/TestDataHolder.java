package com.unitedcoder.integrationtest.database;

public class TestDataHolder {
    private static String customerFirstName;
    private static String customerEmail;
    private static String categoryName;
    private static String productName;


    public static String getCustomerFirstName() {
        return customerFirstName;
    }

    public static void setCustomerFirstName(String customerFirstName) {
        TestDataHolder.customerFirstName = customerFirstName;
    }

    public static String getCustomerEmail() {
        return customerEmail;
    }

    public static void setCustomerEmail(String customerEmail) {
        TestDataHolder.customerEmail = customerEmail;
    }

    public static String getCategoryName() {
        return categoryName;
    }

    public static void setCategoryName(String categoryName) {
        TestDataHolder.categoryName = categoryName;
    }

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        TestDataHolder.productName = productName;
    }
}
