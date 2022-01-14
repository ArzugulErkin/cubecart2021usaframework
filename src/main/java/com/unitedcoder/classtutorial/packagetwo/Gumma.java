package com.unitedcoder.classtutorial.packagetwo;

import com.unitedcoder.classtutorial.packageone.Alpha;
import com.unitedcoder.classtutorial.packageone.DummyClass;

public class Gumma {
    private String information;

    public Gumma() {
    }

    public Gumma(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public static void main(String[] args) {
        Alpha alpha1=new Alpha("This is public alpha class");
       // System.out.println(alpha1.getInfo());
        DummyClass dummyClass=new DummyClass("This is a dummy class that has no modifier for get and set methods");
        //System.out.println(dummyClass.getInfo());
    }

    @Override
    public String toString() {
        return "Gumma{" +
                "information='" + information + '\'' +
                '}';
    }
}
