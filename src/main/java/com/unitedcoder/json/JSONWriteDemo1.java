package com.unitedcoder.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class JSONWriteDemo1 {
    public static void main(String[] args) {
        User testUser=new User("testautomation1","automation123!","admin",30,true);
        //we use Object Mapper
        ObjectMapper objectMapper=new ObjectMapper();
        String userInfo=null;
        try {
            userInfo=objectMapper.writeValueAsString(testUser);
            System.out.println(userInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //write the json data to a json file
        try {
            FileUtils.writeStringToFile(new File("doc\\userdata.json"),userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
