package com.unitedcoder.datatype;


import java.util.Scanner;

public class ConsoleInputDemo {
    public static void main(String[] args)
    {
        //define a scanner object variable to input data from the console
        Scanner input=new Scanner(System.in);
        System.out.println("Please input the first number: ");
        int x=input.nextInt();
        System.out.println("Please input the 2nd number:  ");
        int y=input.nextInt();
        System.out.println("Please input the 3rd number: ");
        int z=input.nextInt();
        int sum=x+y+z;
        System.out.println(String.format("%d +%d + %d=%d",x,y,z,sum));
    }
}
