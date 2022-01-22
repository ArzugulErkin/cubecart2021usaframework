package com.unitedcoder.exceptionhandling;

public class ExceptionDemo1 {
    //checked exception & unchecked exception
    public static void main(String[] args) {
        //we need to handle arithmetic exceptions
        if(args.length>=2) {
            try{
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
                float c=a/b;
                System.out.println("Division value: "+c);
            }
            catch (ArithmeticException myException)
            {
                System.out.println(myException.getMessage());
                myException.printStackTrace();
            }
            catch (NumberFormatException e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            finally {
                System.out.println("division code is complete");
            }
        }
        //wait 2 seconds

        try {
            Thread.sleep(2000);  //checked exception
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("time is up");
    }
}
