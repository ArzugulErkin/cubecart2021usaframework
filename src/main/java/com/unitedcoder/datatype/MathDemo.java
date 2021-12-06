package com.unitedcoder.datatype;

import java.util.Scanner;

public class MathDemo {
    public static void main(String[] args)
    {
        //Using Math object to find square root, power, absolute value, min, max
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please input an integer number r: ");
        int r=scanner.nextInt();
        double area=Math.PI*r*r;
        System.out.println(String.format("area is %.2f",area));
        //find a square root of a number
        System.out.println(Math.sqrt(64));
        //find a power of a number
        System.out.println(10*10*10);
        System.out.println(Math.pow(10,3));
        //get absolute value
        System.out.println(Math.abs(-250));
        //get max value    25, 20, 35
        int temp=Math.max(25,20);
        System.out.println(Math.max(temp,35));
        //get the min value
        System.out.println(Math.min(100,300));
    }
}
