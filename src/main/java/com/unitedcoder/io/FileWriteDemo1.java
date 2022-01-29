package com.unitedcoder.io;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class FileWriteDemo1 {
    public static void main(String[] args) {
        StringBuilder fileContent=new StringBuilder();
        fileContent.append("I love coding in Java").append("\n");
        fileContent.append("Java coding is really fun \n");
        fileContent.append("Java Test Automation Training by United Coder \n");
        fileContent.append("Test Automation \n").append("using Selenium Webdriver");

        FileUtility fileUtility=new FileUtility();

        fileUtility.writeToFile("doc","test-result-"+getCurrentDateTime(),".txt",
                fileContent.toString());
    }
    public static String getCurrentDateTime()
    {
        //define a new joda date time object instance
        DateTime dt1=new DateTime();
        //formatting date time
        DateTimeFormatter formatter= DateTimeFormat.forPattern("yyyy-MM-dd-HH-mm-ss-SSS");
        return dt1.toString(formatter);
    }
}
