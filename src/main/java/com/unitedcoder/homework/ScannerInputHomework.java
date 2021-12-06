package com.unitedcoder.homework;

import java.util.Scanner;

public class ScannerInputHomework {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String temp;
        String finalAddress="";
        String[] questions=new String[]{"name","street address","city name","state"};
        for(int i=0;i<4;i++)
        {
            System.out.println("What is your " +questions[i]);
            temp=input.nextLine();
            finalAddress=finalAddress+temp+" ";
        }
        System.out.println(String.format("Mailing Address: %s",finalAddress));
    }
}
