package com.unitedcoder.integrationtest.database;

public class TestDataHolder {
    private static String customerFirstName;
    private static String customerEmail;
    private static String categoryName;

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
}
