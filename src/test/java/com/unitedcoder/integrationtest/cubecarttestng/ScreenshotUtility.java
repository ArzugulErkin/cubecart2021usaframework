package com.unitedcoder.integrationtest.cubecarttestng;

import com.unitedcoder.configutility.ApplicationConfig;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtility {
    public void captureImage(String filename, WebDriver driver)
    {
        DateTime dt1=new DateTime();
        //use formatter to print the date time in yyyy-MM-dd-HH-mm-ss-sss format
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        String timestamp=dt1.toString(formatter);
        filename=filename+"-"+timestamp;
        File imageFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        ApplicationConfig applicationConfig=new ApplicationConfig();
        String imageFolder=applicationConfig.readConfigProperties("config-qa.properties","screenshot");
        try {
            FileUtils.copyFile(imageFile,new File(imageFolder+File.separator+filename+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
