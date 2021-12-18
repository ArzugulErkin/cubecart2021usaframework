package com.unitedcoder.homework;

public class ArrayErrorCodeDemo {
    public static void main(String[] args) {
        double[] values=new double[10]; //n-1
        for(int i=1;i<=10;i++) {
            values[i] = i * i;
            System.out.println(values[i]);
        }
    }
}
