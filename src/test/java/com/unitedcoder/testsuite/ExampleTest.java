package com.unitedcoder.testsuite;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ExampleTest {
    @Test
    public void loginTest()
    {
        System.out.println("This is a login test");
        Assert.assertTrue(Math.sqrt(9)==3.00);
    }
}
