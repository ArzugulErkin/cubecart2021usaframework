package com.unitedcoder.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExceptionDemo2 {
    //let's create a text file with some error
    public static void main(String[] args) {
        if(args.length>=2) {
            try{
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);
                float c=a/b;
                System.out.println("Division value: "+c);
            }
            catch (ArithmeticException myException)
            {
                //define a file Object
                File logFile=new File("error"+System.currentTimeMillis()+".txt"); //define a text file
                PrintWriter writer= null;
                try {
                    writer = new PrintWriter(logFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                writer.write(myException.getMessage());
                writer.close();
            }
            finally {
                System.out.println("division code is complete");
            }
        }
        //wait 2 seconds

        try {
            Thread.sleep(2000);  //checked exception
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("time is up");
    }
    }
