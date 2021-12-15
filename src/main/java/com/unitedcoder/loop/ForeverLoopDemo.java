package com.unitedcoder.loop;

public class ForeverLoopDemo {
    /*
    Example: You want to count from 1 to infinite;
    When you count up to 3000, you stop counting.
     */
    public static void main(String[] args) {
        for(int i=1;;i++)   //infinite loop , forever loop
        {
            System.out.print(i+" ");
            if(i%5==0)
            {
                System.out.println();
            }
            if(i>=5000)
                break;
        }
    }
}
