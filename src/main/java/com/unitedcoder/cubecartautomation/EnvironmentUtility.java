package com.unitedcoder.cubecartautomation;

public class EnvironmentUtility {
    public String getConfigFileByEnvironment(Environment environment)
    {
        String configFileName=null;
        switch (environment)
        {
            case QA:
                configFileName="config-qa.properties";
                break;
            case PROD:
                configFileName="config-prod.properties";
                break;
            default:
                configFileName="config-qa.properties";
                break;
        }
        return configFileName;
    }
}
