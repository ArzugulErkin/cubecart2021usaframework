package com.unitedcoder.classtutorial.packagetwo;

import com.unitedcoder.classtutorial.packageone.Alpha;

public class AlphaSub extends Alpha {
    public AlphaSub(String info) {
        super(info);
    }

    public static void main(String[] args) {
        Alpha myAlpha=new Alpha("This is public alpha class");
        //System.out.println(myAlpha.getInfo());

    }
}
