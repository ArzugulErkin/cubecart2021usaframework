package com.unitedcoder.datastructure;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] numbers=new int[]{1,10,4,20,15,30,56,78,90,95, 23, 45, 33, 42, 11, 5, 7};
        System.out.println(Arrays.toString(numbers));
        System.out.println();
        //get total counts
        int n=numbers.length;
        int temp=0; //this is a temporary number
        //bubble sort logic
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<(n-i);j++)
            {
                //bubble sort logic
                if(numbers[j-1]>numbers[j])
                {
                    temp=numbers[j-1];
                    numbers[j-1]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
        //print out the bubble sort values
        for(int number:numbers)
        {
            System.out.print(number+" ");
        }
    }
}
