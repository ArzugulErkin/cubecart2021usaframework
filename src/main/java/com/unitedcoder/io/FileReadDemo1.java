package com.unitedcoder.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class FileReadDemo1 {
    public static void main(String[] args) {
        //read a text file
        //when using a static method, you do not create a new instance of the object
        //instead, you use Object.methodName
        try {
        //Mac User  folder/filename    doc/test-result.txt   doc/myfile.txt
       String content=FileUtils.readFileToString(new File("doc\\myfile.txt"),"UTF-8");
            System.out.println(content);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
