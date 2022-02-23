package com.unitedcoder.cubecartjunit;


import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)// default

public class JUnitTestDemo2 {


    @BeforeAll
    public static void setUp()
    {
        System.out.println("Before all will run only once in the Junit framework before ant test");
    }
    @BeforeEach
    public void beforeTestInfo()
    {
        System.out.println("test start .........");
    }
    @AfterEach
    public void afterTestInfo()
    {
        System.out.println("test end........");
    }
    @Order(1)
    @Test
    @Tag("Smoke Test")
    public void squareRootTest()
    {
        System.out.println("This is for testing a square  root");
        Assertions.assertTrue(Math.sqrt(9)==3.0);
    }
    @Order(2)
    @Test
    @Tag("Smoke Test")
    public void compareStringTest() {
        String s1 = "selenium";
        String s2 = "selenium";
        Assertions.assertEquals(s1, s2);

    }
    @Test
    @Order(3)
    @Tag("Regression Test")
     public void mathPowerTest()
    {
        System.out.println("This is for testing a power of a number ");
        Assertions.assertTrue(Math.pow(10,2)==100);
    }

            @AfterAll
            public static void tearDown()

            {
                System.out.println("after all will run only once in the JUint framework after any test");
            }

        }




