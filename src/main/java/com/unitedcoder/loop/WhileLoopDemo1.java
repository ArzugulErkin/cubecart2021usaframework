package com.unitedcoder.loop;

public class WhileLoopDemo1 {
    public static void main(String[] args)
    {
        //Using the while loop, print numbers from 1 to 100;
        int i=0;
        int maxNumber=100;
        while (i<maxNumber)
        {
            i++;
            System.out.print(i+" ");  //  System.out.print(String.format("%d ",i));
            if(i%5==0)  //if number is divided by 5 , then change a line
                System.out.println();
        }
       // Using the while loop, print even numbers from 1 to 100;
        // Using the while loop, print odd numbers from 1 to 100;
        int j=0;
        String evenNumbers="";
        String oddNumbers="";
        while (j<100)
        {
            j++;
            if(j%2==0)  //if number is divided by 2, it is an even number
            evenNumbers=evenNumbers+j+" ";  //this is to collect even numbers
            else
             oddNumbers=oddNumbers+j+" "; //this is to collect odd number
        }
        System.out.println(evenNumbers);
        System.out.println(oddNumbers);
    }
}
