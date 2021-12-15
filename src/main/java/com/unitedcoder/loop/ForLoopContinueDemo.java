package com.unitedcoder.loop;

public class ForLoopContinueDemo {
    /*
    Example: write a java code to print numbers from 1 to 100 and only print those
    numbers that can NOT be divided by 2 or 3 or 5;
     */
    public static void main(String[] args) {
        int i=0;

        for(i=0;i<=100;i++) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0)
                continue;   //if the condition is true, it will resume next loop, else execute the next statement
            System.out.print(i+" ");
        }
    }

}
