package com.unitedcoder.classtutorial;

import java.util.Arrays;

public class SchoolApplication {
    public static void main(String[] args) {
        School mySchool=new School();
        mySchool.location="Columbia, MD, United States";
        mySchool.name="United Coder";
        mySchool.programs= Arrays.asList("Software Test Automation","Software Developers");
        mySchool.type="Professional Job Training";
    }
}
