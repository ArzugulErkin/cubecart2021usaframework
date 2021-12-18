package com.unitedcoder.datastructure;
import java.util.Scanner;
public class BirthDayLookUp {
    public static void main(String[] args) {
        String[][] birthdays = new String[][]
                {
                        {"Aliya", "09/12"}, {"Zulhumar", "3/18"}, {"Manizha", "2/23"}, {"Tursunay", "10/26"},
                        {"Dilmurat", "12/16"}, {"Gulnur", "1/1"}, {"Sintia", "1/18"}, {"Arzigul", "7/1"},
                        {"Nadire", "8/12"}, {"Akhtam", "2/25"}, {"Dolkun", "01/20"}, {"Rifat", "2/03"},
                        {"Pazilat", "6/7"}, {"Amina", "10/03"}, {"Aini", "06/04"}, {"Sayyada", "09/05"},
                        {"Muyesser", "12/28"}, {"Halide", "12/4"}, {"Maryam", "3/10"}
                };
        //get total birthdays
        int totalBirthdays = birthdays.length;
        Scanner input = new Scanner(System.in);
        int totalRightSearch = 0;
        for (int search = 0; ; search++) {
            boolean isUserFound = false;
            System.out.println("Please enter a name to search the birthday: ");
            String name = input.next();
            for (int n = 0; n < totalBirthdays; n++) {
                if (name.equalsIgnoreCase(birthdays[n][0])) {
                    System.out.println(name + "birthday: " + birthdays[n][1]);
                    isUserFound = true;
                    totalRightSearch++;
                    break;
                }
            }
                if (!isUserFound) System.out.println("the user is not found");
                if (totalRightSearch == totalBirthdays) {
                    System.out.printf("You did right search %d times", totalRightSearch);
                    System.out.printf("Your total search is %d", search);
                    System.out.printf("Your wrong search is %d", search - totalRightSearch);
                    break;
                }
            }
        }
    }


