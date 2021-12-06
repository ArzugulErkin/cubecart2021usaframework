package com.unitedcoder.datatype;

public class ArgumentDemo {
    // I want to calculate the sum of any 3 numbers; the numbers should be passed as arguments
    public static void main(String[] args)
    {
        int x=Integer.parseInt(args[0]);  //argument 0 will be converted to an integer number
        int y=Integer.parseInt(args[1]); //argument 1 will be converted to an integer number
        int z=Integer.parseInt(args[2]);//argument 2 will be converted to an integer number
        int sum=x+y+z;
        System.out.println(String.format("%d + %d + %d = %d", x, y, z, sum));
    }
}
