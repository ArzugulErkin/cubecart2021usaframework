package com.unitedcoder.datastructure;

import java.util.Arrays;

public class ArrayDemo2 {
    public static void main(String[] args) {
        //define an array with numbers
        int[] numbers=new int[]{1,10,4,20,15,30,56,78,90,95};
        //print numbers in ascending orders - 1,4,10,15,20,30,56,78,90,95
        //print numbers in descending orders - 95,90,78,56,30,20,15,10,4,1
        System.out.println(Arrays.toString(numbers));
       for(int n:numbers)
       {
           System.out.print(n+" ");
       }
       //sort the array   - use Arrays object to sort
        System.out.println();
       Arrays.sort(numbers);  //ascending order
       for(int i: numbers)
       {
           System.out.print(i+" ");
       }
       //sort the array in descending order
        System.out.println("Print the array in descending order");
        for(int i=numbers.length-1;i>=0;i--)
        {
            System.out.print(numbers[i]+" ");
        }
    }
}
