package com.unitedcoder.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {
    //design a method to write a text file
    public void writeToFile(String fileFolder,String fileName,String fileExtension, String fileContent)
    {
        //create a folder if the folder does not exist
        String workingDirectory=System.getProperty("user.dir"); //return current working folder
        String finalDirectory=workingDirectory+ File.separator+fileFolder; //folder of the file
        System.out.println(finalDirectory);
        File file=new File(finalDirectory);
        //if the folder does not exist, then create the folder
        if(!file.exists())
        {
            file.mkdir();
            System.out.println("Folder is created");
        }
        //final file name
        String finalFileName=finalDirectory+File.separator+fileName+fileExtension;
        //write file content to the file
        File myFile=new File(finalFileName);
        FileWriter fileWriter=null;  //create a FileWriter object instance
        try {
            fileWriter=new FileWriter(myFile.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //write content using buffer - create a buffer instance
        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
        try {
            bufferedWriter.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
