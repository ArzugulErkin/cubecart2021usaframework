package com.unitedcoder.decision;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class GradeDemo {
    public static void main(String[] args) {
        System.out.println("Please input a grade");
        Scanner gradeInput = new Scanner(System.in);
        String grade = gradeInput.next();
        //if the string is not a numeric string, print error message on the screen
        if (!StringUtils.isNumeric(grade) ||Integer.parseInt(grade) > 100 || Integer.parseInt(grade) < 0)
            System.out.println("Please enter a valid grade from 1 to 100");
        else
        {
            int myGrade=Integer.parseInt(grade);  //convert numeric String grade to integer
            if (myGrade >= 90 && myGrade <= 100)
                System.out.println("Your grade is an A");
            else if (myGrade >= 80 && myGrade < 90)
                System.out.println("Your grade is a B");
            else if (myGrade >= 70 && myGrade < 80)
                System.out.println("Your grade is a C");
            else
                System.out.println("You failed, please work harder");
        }
    }
}
