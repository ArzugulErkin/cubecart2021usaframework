package com.unitedcoder.multithreading;

import java.util.Date;

public class GreetingPrinting implements Runnable{
    private String message;

    public GreetingPrinting(String message) {
        this.message = message;
    }
    @Override
    public void run() {
        //write our logic to print message
        for(int i=0;i<=5;i++)
        {
            Date now=new Date(); //get current time
            System.out.println(now+" "+message);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
