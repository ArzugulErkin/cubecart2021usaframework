package com.unitedcoder.integrationtest.cubecarttestng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGDemo3 {

    @Test(description = "Add customer test",groups = {"add customer"})
    public void addCustomerTest()
    {
        System.out.println("This is a test for adding a customer");
        Assert.assertTrue("Add customer".contains("customer"));
    }
    @Test
    public void addCategoryTest()
    {
        System.out.println("This is a test for adding a category");
        Assert.assertTrue(Math.pow(10,2)==100);
    }
    @Test(description = "Delete customer test",dependsOnGroups = {"add customer"})
    public void deleteCustomerTest()
    {
        System.out.println("This is for deleting customer test");
        Assert.assertTrue("Delete customer".contains("Delete"));
    }
    @Test(dependsOnMethods = {"addCategoryTest"})
    public void deleteCategoryTest()
    {
        Assert.assertTrue("Category".length()>5);
    }
}
