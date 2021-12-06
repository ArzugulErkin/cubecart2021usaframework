package com.unitedcoder.datatype;

public class IncrementOperatorDemo2 {
    public static void main(String[] args) {
        int i=1,j;
        j=i++;  //after the operation is done, then i will increase
        System.out.println(String.format("i=%d j=%d",i,j));

        int k=++i; //pre increment and then assign value
        System.out.println(String.format("k=%d  j=%d",k,j));
    }
}
