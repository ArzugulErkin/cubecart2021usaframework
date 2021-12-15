package com.unitedcoder.loop;

import java.util.Scanner;

public class DiamondShapeDemo {
    public static void main(String[] args) {
        System.out.println("Please enter your diamond tower height? ");
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();   //for rows
        int s=n-1; //for columns
        int totalRows=2*n-1;
        System.out.println("A diamond with "+totalRows +" rows");
        for(int i=0;i<n;i++)     //this is for the row
        {
            for(int j=0;j<s;j++)
                System.out.print(" ");  //print space
            for(int j=0;j<=i;j++)
                System.out.print("A "); //print the star and the space
            System.out.print("\n");  //after each row, we change to next line
            s--;
        }
        s=0;
        for(int i=n-1;i>0;i--)
        {
            for(int j=0;j<s;j++)
                System.out.print(" ");
            for(int k=0;k<i;k++)
                System.out.print(" A");
            System.out.print("\n");
            s++;
        }
    }
}
