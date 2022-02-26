package com.unitedcoder.integrationtest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest {
    @Test
    public void loginTest()
    {
        System.out.println("This is a login test");
        Assert.assertTrue(Math.sqrt(9)==3.00);
        System.out.println("This is a dummy output for my inventory automation taks one");
    }
}
