package com.unitedcoder.homework;
public class LoopPrintDemo {
    public static void main(String[] args) {
        String numbersDividedBy3="";
        String numbersDividedBy5="";
        String numbersDividedBy15="";
        String otherNumbers="";
        for(int i=1;i<=500;i++)
        {
            if(i%15==0) {
                numbersDividedBy15 = numbersDividedBy15 + i + " ";
                numbersDividedBy3=numbersDividedBy3+i+" ";
                numbersDividedBy5=numbersDividedBy5+i+" ";
            }
            else if(i%5==0)
                numbersDividedBy5=numbersDividedBy5+i+" ";
            else if(i%3==0)
                numbersDividedBy3=numbersDividedBy3+i+" ";
            else
                otherNumbers=otherNumbers+i+" ";
        }
        System.out.println("Numbers divided by 3 \n"+numbersDividedBy3);
        System.out.println("Numbers divided by 5 \n"+numbersDividedBy5);
        System.out.println("Numbers divided by 15 \n"+numbersDividedBy15);
    }
}
