package com.unitedcoder.datastructure;

public class StringSplitArrayDemo {
    public static void main(String[] args) {
        String students="Mike,Jason,Maria, Shaun, Patil, Christina, Allison";
        String[] studentArray=students.split(",");
        for(String eachStudent:studentArray)
        {
            System.out.println(eachStudent);
        }
        //you have lots of number in a string, you need to sum the values and get the average
        String numbers="20,34,56,78,90,11,15,89,75,65,32,21,43,56,50,10,2,1,5";
        String[] allNumbers=numbers.split(",");
        int sum=0;
        for(String eachNumber: allNumbers)
        {
            sum=sum+Integer.parseInt(eachNumber);
        }
        System.out.println("Total sum is "+sum);
        int totalNumbers=allNumbers.length;
        float average=(float)sum/totalNumbers;
        System.out.printf("average is: %.2f",average);
    }
}
