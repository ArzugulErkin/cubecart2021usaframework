package com.unitedcoder.methodtutorial;

public class ChildClass extends ParentClass{
    //define an overriding method for printInfo
    public void printInfo()
    {
        System.out.println("This is a child class");
    }

    public static void main(String[] args) {
        ChildClass childClass=new ChildClass();
        childClass.printInfo();
    }
}
