package com.unitedcoder.multithreading;

public class MultiThreadingDemo1 {
    public static void main(String[] args) {
        //I want to print 4 messages on the screen concurrently
        //define objects to run concurrently
        GreetingPrinting gp1=new GreetingPrinting("Hello Test Automation");
        GreetingPrinting gp2=new GreetingPrinting("Java multi threading is fun");
        GreetingPrinting gp3=new GreetingPrinting("United Coder SDET Learning");
        GreetingPrinting gp4=new GreetingPrinting("We learned a lot about Java test automation");
        GreetingPrinting gp5=new GreetingPrinting("Multi Threading Demo");
        //define thread
        Thread thread1=new Thread(gp1);
        printThreadInformation(thread1);

        Thread thread2=new Thread(gp2);
        printThreadInformation(thread2);

        Thread thread3=new Thread(gp3);
        printThreadInformation(thread3);

        Thread thread4=new Thread(gp4);
        printThreadInformation(thread4);

        Thread thread5=new Thread(gp5);
        printThreadInformation(thread5);
        //start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
    public static void printThreadInformation(Thread thread)
    {
        System.out.println("Thread Id: "+thread.getId());
        System.out.println("Thread name: "+thread.getName());
    }
}
