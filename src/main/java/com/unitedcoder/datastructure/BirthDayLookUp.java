package com.unitedcoder.datastructure;

import java.util.Scanner;

public class BirthDayLookUp {
    public static void main(String[] args) {

        String[] names=new String[]{"Aliya","Zulhumar","Manizha", "Tursunay", "Dilmurat","Gulnur",
        "Sintia","Arzigul","Nadire","Aktam","Dolkun","Rifat","Pazilat",
                "Amina","Aini","Sayyada","Muyesser","Halide","Maryam"};
        int totalBirthdays=names.length;
        System.out.println("Total names: "+totalBirthdays);
        Scanner scanner = new Scanner(System.in);
        for (int time = 0;time<=totalBirthdays ; time++) {
            System.out.println("Please Enter Your Name To Look Up Your BirthDay: ");
            String name = scanner.next();
            for(String eachBirthday: names)
            {
                if(name.equalsIgnoreCase(eachBirthday))
                {
                    System.out.println("Found the birthday person");
                }
                break;
            }

            if (name.equalsIgnoreCase(names[0])) {
                System.out.println("Aliya's Birthday is 9/12");
            } else if (name.equalsIgnoreCase(names[1])) {
                System.out.println("Zhlhumar's Birthday is 3/18");
            } else if (name.equalsIgnoreCase(names[2])) {
                System.out.println("Manizha's Birthday is 2/23");
            } else if (name.equalsIgnoreCase(names[3])) {
                System.out.println("Tursunay's Birthday is 10/26");
            } else if (name.equalsIgnoreCase(names[4])) {
                System.out.println("Dilmurat's Birthday is 12/16");
            } else if (name.equalsIgnoreCase(names[5])) {
                System.out.println("Gulnur's Birthday is 1/1");
            } else if (name.equalsIgnoreCase(names[6])) {
                System.out.println("Sintia's Birthday is 1/28");
            } else if (name.equalsIgnoreCase(names[7])) {
                System.out.println("Arzihul's Birthday is 7/1");
            } else if (name.equalsIgnoreCase(names[8])) {
                System.out.println("Nadira's Birthday is 8/12");
            } else if (name.equalsIgnoreCase(names[9])) {
                System.out.println("AKhtam's Birthday is 2/25");
            } else if (name.equalsIgnoreCase(names[10])) {
                System.out.println("Mr.Tarim's Birthday is EVERY DAY");
            } else if (name.equalsIgnoreCase(names[11])) {
                System.out.println("Rifat's Birthday is UNKNOWN");
            } else if (name.equalsIgnoreCase(names[12])) {
                System.out.println("Pazilat's Birthday is 6/7");
            } else if (name.equalsIgnoreCase(names[13])) {
                System.out.println("Amina's Birthday is UNKNOWN");
            } else if (name.equalsIgnoreCase(names[14])) {
                System.out.println("Aini's Birthday is UNKNOWN");
            } else if (name.equalsIgnoreCase(names[15])) {
                System.out.println("Sayyada's Birthday is 9/5");
            } else if (name.equalsIgnoreCase(names[16])) {
                System.out.println("Muyesser's Birthday is UNKNOWN");
            } else if (name.equalsIgnoreCase(names[17])) {
                System.out.println("Halide's Birthday is 12/4");
            } else if (name.equalsIgnoreCase(names[18])) {
                System.out.println("Maryam's Birthday is UNKNOWN");
            } else
                System.out.println("Please Re-Enter Your Name: ");
        }


    }
}
