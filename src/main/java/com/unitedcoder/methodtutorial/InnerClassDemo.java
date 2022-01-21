package com.unitedcoder.methodtutorial;

public class InnerClassDemo {
    public static void main(String[] args) {
        OuterClass myouterClass=new OuterClass(); //new instance of the OuterClass

        OuterClass.innerClass myInnerClass=myouterClass.new innerClass();

        System.out.println(myouterClass.x+ myInnerClass.y);
        myInnerClass.print();
    }
}
