package com.unitedcoder.integrationtest.cubecarttestng;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class CustomResultListener implements ITestListener {
 static List<ITestNGMethod> passedTests=new ArrayList<>();
 static List<ITestNGMethod> failedTests=new ArrayList<>();
 static List<ITestNGMethod> skippedTests=new ArrayList<>();
 ScreenshotUtility screenshotUtility=new ScreenshotUtility();

 public void onTestFailure(ITestResult result)
 {
  failedTests.add(result.getMethod());
  screenshotUtility.captureImage(result.getMethod().getMethodName().trim()+"-fail",
          (WebDriver) result.getTestContext().getAttribute("driver"));
 }

 public void onTestSuccess(ITestResult result)
 {
  passedTests.add(result.getMethod());

  screenshotUtility.captureImage(result.getMethod().getMethodName().trim()+"-pass",
          (WebDriver) result.getTestContext().getAttribute("driver"));

 }
 public void onTestSkipped(ITestResult result)
 {
  skippedTests.add(result.getMethod());
 }

}
