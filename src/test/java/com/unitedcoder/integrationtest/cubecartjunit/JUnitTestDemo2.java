package com.unitedcoder.integrationtest.cubecartjunit;

import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  //default
public class JUnitTestDemo2 {
  @BeforeAll
    public static void setUp()
  {
      System.out.println("Before all will run only once in the Junit framework before any test");
  }
  @BeforeEach
  public void beforeTestInfo()
  {
      System.out.println("test start ....... ");
  }
  @AfterEach
  public void afterTestInfo()
  {
      System.out.println("test end ...... ");
  }
  @Test
  @Order(1)
  @Tag("Smoke Test")
  public void squareRootTest()
  {
      System.out.println("This is for testing a square root");
      Assertions.assertTrue(Math.sqrt(9)==3.0);
  }
  @Test
  @Order(2)
  @Tag("Smoke Test")
   public   void compareStringTest()
  {
      String s1="selenium";
      String s2="selenium";
      Assertions.assertEquals(s1,s2);
  }
  @Test
  @Order(3)
  @Tag("Regression Test")
  public void mathPowerTest()
  {
      System.out.println("This is for testing a power of a number");
      Assertions.assertTrue(Math.pow(10,2)==100);
  }
  @AfterAll
    public static void tearDown()
  {
      System.out.println("After all will run only once in the JUnit framework after any test");
  }

}

