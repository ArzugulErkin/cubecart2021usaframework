package com.unitedcoder.loop;
import java.util.Random;
import java.util.Scanner;
public class LotteryGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int winCounnts=0;
        for(int i=1;i<=30;i++)
        {
            System.out.println("Press Enter to continue");
            scanner.nextLine(); //press enter
            Random random=new Random();
            int lotteryNumber=random.nextInt(10);
            System.out.println("Your lottery number is "+lotteryNumber);
            if(lotteryNumber==5)
            {
                System.out.println("You won the lottery");
                winCounnts++;
            }
            else
                System.out.println("Try again, you lost");
        }
        System.out.println("Your total win is "+winCounnts);
    }
}
