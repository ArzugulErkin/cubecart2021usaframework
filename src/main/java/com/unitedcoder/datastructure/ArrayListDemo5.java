package com.unitedcoder.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListDemo5 {
    public static void main(String[] args) {
        Scanner myScanner=new Scanner(System.in);
        System.out.println("Please input a number less than or equal to 100");
        int myNumber=myScanner.nextInt();
        List<Integer> numberList=new ArrayList<>();
        numberList.add(100);
        numberList.add(95);
        numberList.add(85);
        numberList.add(90);
        System.out.println(numberList);
        //use the contains method to verify some numbers in the number list
        if(numberList.contains(myNumber))
            System.out.println("The list contains number "+myNumber);
        else {
            System.out.println("the number is not found");
        }
        numberList.clear(); //make the list/arraylist empty
        System.out.println("The size of the number list after clearing "+numberList.size());
        System.out.println(numberList);

    }
}
