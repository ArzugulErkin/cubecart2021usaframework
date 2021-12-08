package com.unitedcoder.loop;

public class ForLoopDemo1 {
    public static void main(String[] args) {
        //print out 1 to 100
        for(int i=1;i<=100;i++)
        {
            System.out.print(i+" ");
        }
        System.out.println("\n Printing even numbers from 1 to 100");
        //print all even numbers from 1 to 100 - 2,4,6,8,10,12...... 100
        for(int j=2;j<=100;j=j+2)
        {
            System.out.print(j+" ");
        }
        System.out.println("\n Printing odd numbers from 1 to 100");
        //print all odd numbers from 1 to 100 - 1, 3, 5, 7, 9, 11, 13,15... 99
        for(int x=1; x<=100;x=x+2)
        {
            System.out.print(x+" ");
        }
        //print 100 to 1 in descending order - 100,99,98....... 1
        System.out.println("\n Printing numbers from 100 to 1 in the descending order");
        for(int n=100; n>=1;n--)
        {
            System.out.print(n+" ");
        }
    }
}
