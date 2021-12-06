package com.unitedcoder.datatype;


import java.util.Scanner;

public class ConsoleInputDemo2 {
    public static void main(String[] args)
    {
        //define a scanner object variable to input data from the console
        Scanner input1=new Scanner(System.in);
        Scanner input2=new Scanner(System.in);
        Scanner input3=new Scanner(System.in);
        System.out.println("Please input the first number: ");
        int x=input1.nextInt();
        System.out.println("Please input the 2nd number:  ");
        int y=input2.nextInt();
        System.out.println("Please input the 3rd number: ");
        int z=input3.nextInt();
        int sum=x+y+z;
        System.out.println(String.format("%d +%d + %d=%d",x,y,z,sum));
    }
}
