package com.unitedcoder.loop;

public class MultiplicationChartDemo2 {
    public static void main(String[] args) {
        int rows=10;
        for(int x=1;x<=rows;x++)  //loop the rows
        {
            for(int y=1;y<=x;y++)  //loop the columns
            {
                int multiply=x*y;
                System.out.print(String.format("%d*%d=%d  ",x,y,multiply));
            }
            System.out.println(); //add a new line
        }
    }
}
