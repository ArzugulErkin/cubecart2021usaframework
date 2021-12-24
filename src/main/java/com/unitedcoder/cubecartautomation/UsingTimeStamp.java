package com.unitedcoder.cubecartautomation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UsingTimeStamp {
    public static void main(String[] args) throws InterruptedException {
        for(int x=0;x<5;x++)
        {
            long currentTimeStamp=System.currentTimeMillis();
            System.out.println(currentTimeStamp);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            Thread.sleep(5000);
        }
    }
}
