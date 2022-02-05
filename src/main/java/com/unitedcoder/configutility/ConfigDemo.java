package com.unitedcoder.configutility;

public class ConfigDemo {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig=new ApplicationConfig();
        String configFilename="config-qa.properties";
        applicationConfig.readConfigProperties(configFilename,"username");
        applicationConfig.readConfigProperties(configFilename,"password");
        applicationConfig.readConfigProperties(configFilename,"url");
        applicationConfig.readConfigProperties(configFilename,"timeout");
    }
}
