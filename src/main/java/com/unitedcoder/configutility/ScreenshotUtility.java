package com.unitedcoder.configutility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {
    WebDriver driver;
    public ScreenshotUtility(WebDriver driver)
    {
        this.driver=driver;
    }
    public void takeScreenshot(String folder,String filename)
    {
        TakesScreenshot screenshot=(TakesScreenshot) driver; //you create a take screenshot interface
        File screenshotFile=screenshot.getScreenshotAs(OutputType.FILE);
        File imageFile=new File(folder+File.separator+filename); // this is the screenshot image file
        try {
            FileUtils.copyFile(screenshotFile,imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
