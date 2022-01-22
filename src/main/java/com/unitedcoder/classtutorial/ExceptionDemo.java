package com.unitedcoder.classtutorial;

public class ExceptionDemo {

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
