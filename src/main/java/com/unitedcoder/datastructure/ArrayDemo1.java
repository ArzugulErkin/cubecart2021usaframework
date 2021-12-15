package com.unitedcoder.datastructure;

public class ArrayDemo1 {
    //define an array
    //assign value to an array
    //count the elements of the array
    public static void main(String[] args) {
       int[] numbers=new int[10]; //initializer means you either define the length or give initial values, n-1
        System.out.println(numbers[0]);  //print the first number
        System.out.println(numbers[1]); //print the second number
        System.out.println(numbers[9]);
        //let's assign some values to the numbers array
        numbers[0]=150; numbers[1]=200;
        numbers[2]=205; numbers[3]=150;
        numbers[4]=130; numbers[5]=10;
        numbers[6]=15; numbers[7]=500;
        numbers[8]=210; numbers[9]=1000;
        //count the total elements
        System.out.println(numbers.length); //get total count
        //print all elements of the array
        //legacy for loop
        for(int n=0;n<numbers.length; n++)
        {
            System.out.println(String.format("numbers[%d]=%d",n,numbers[n]));   //print each element of the array
        }
        //using enhanced for loop - for each loop
        for(int i:numbers)
        {
            System.out.print(i+" ");
        }
        //sum the value of all elements in the array
        int sum=0;
        for(int i:numbers)
        {
            sum=sum+i; //add each item to the sum
        }
        System.out.println("Total sum of numbers is "+sum);

    }
}
