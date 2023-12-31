package com.unitedcoder.configutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfig {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig=new ApplicationConfig();
     String qaUrl=   applicationConfig.readConfigProperties("config-qa.properties","url");
     String prodUrl=applicationConfig.readConfigProperties("config-prod.properties","url");
        System.out.println(qaUrl);
        System.out.println(prodUrl);
    }
    //write a method to read a specific key value pair from a config.properties file
    public String readConfigProperties(String filename,String key)
    {
        Properties properties=new Properties();
        String value;
        String projectFolder=System.getProperty("user.dir");
        try {
            properties.load(new FileInputStream(projectFolder+ File.separator+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        value=properties.getProperty(key);
        System.out.println(String.format("%s=%s",key,value));
        return value;
    }
}
