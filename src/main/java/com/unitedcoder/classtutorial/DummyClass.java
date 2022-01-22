package com.unitedcoder.classtutorial;

public class DummyClass {
    private String name;
    private static String version;

    public static void main(String[] args) {
        DummyClass dummyClass=new DummyClass();
        dummyClass.name="Test Automation";

        DummyClass.version="2022 Class";

        System.out.println(dummyClass.name);
        System.out.println(version);
    }
}
