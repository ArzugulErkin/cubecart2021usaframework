package com.unitedcoder.datatype;

public class IncrementOperatorDemo {
    //increment operator is used mostly in for loop statement
    // ++    --
    public static void main(String[] args) {
        int i=1;
        int j=1;
        i++; //i=i+1; post increment
        j++; //j=j+1; post increment
        System.out.println(String.format("i=%d j=%d",i,j));
        i--;   //i=i-1;  post decrement
        j--;  // j=j-1   post decrement
        System.out.println(String.format("i=%d j=%d",i,j));

        i=++i;   // pre increment
        j=++j;   //pre increment
        System.out.println(String.format("i=%d j=%d",i,j));

    }
}
