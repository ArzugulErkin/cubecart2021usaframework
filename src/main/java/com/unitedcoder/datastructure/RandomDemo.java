package com.unitedcoder.datastructure;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        //generate 5 random integers
        for(int i=1;i<=10;i++)
        {
            Random random=new Random();
            System.out.print(random.nextInt(50)+",");
        }
        String[] firstNames=new String[100];
        for(int i=0;i<100;i++)
        {
            firstNames[i]=RandomStringUtils.
                    random(10,"abcdefghijklmnopqrstuvwxyz");
        }
        for(String firstName:firstNames)
        {
            System.out.println(firstName);
        }
    }
}
