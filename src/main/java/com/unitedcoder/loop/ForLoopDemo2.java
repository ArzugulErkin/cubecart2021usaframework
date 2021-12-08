package com.unitedcoder.loop;

public class ForLoopDemo2 {
    public static void main(String[] args) {
     int sum=0;
     for(int i=1;i<=100;i++)
     {
         sum=sum+i;
         System.out.println(String.format("i=%d  sum=%d",i,sum));
     }
    }
}
