package com.unitedcoder.multithreading;

public class GoogleSearchMultiThreadDemo {
    public static void main(String[] args) {
        GoogleMultiThreadSearch browser1=new GoogleMultiThreadSearch("New York");
        GoogleMultiThreadSearch browser2=new GoogleMultiThreadSearch("Washington DC");
        GoogleMultiThreadSearch browser3=new GoogleMultiThreadSearch("Boston");
        GoogleMultiThreadSearch browser4=new GoogleMultiThreadSearch("Toronto");
        GoogleMultiThreadSearch browser5=new GoogleMultiThreadSearch("Istanbul");
        //define each thread
        Thread thread1=new Thread(browser1);
        Thread thread2=new Thread(browser2);
        Thread thread3=new Thread(browser3);
        Thread thread4=new Thread(browser4);
        Thread thread5=new Thread(browser5);
        //start the threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
