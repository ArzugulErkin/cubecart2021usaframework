package com.unitedcoder.datatype;

public class ArithmeticOperatorDemo {

    public static void main(String[] args) {
        // calculate an area of a rectangle
        int width=15; int length=10;
        int area=width*length;
        int perimeter=2*(width+length);
        System.out.println(String.format("area=%d",area));
        System.out.println(String.format("perimeter=%d", perimeter));
        float divResult=(float) width/length;
        System.out.printf("\n divResult=%f",divResult);
        int diff=width-length;
        System.out.println();
        System.out.println(String.format("%d - %d = %d",width,length,diff));
        // % symbol is for remainder
        System.out.println((float)5/2); //this is to get the number after the division
        System.out.println(5%2); //this is to get the remainder after the division
        //even number if you divide the number by %2=0
        System.out.println(8%2);  //even number
        System.out.println(7%2);  //odd number
    }

}
