package com.unitedcoder.datastructure;

public class ArrayDemo3 {
    public static void main(String[] args) {
        //row A seat 1,2,3,4,5,6
        //row B seat 1,2,3,4,5,6
        //row C seat 1,2,3,4,5,6
        String[][] seats=new String[][]{
                {"A1","A2","A3","A4","A5","A6"},
                {"B1","B2","B3","B4","B5","B6"},
                {"C1","C2","C3","C4","C5","C6"}
        };
        int totalRows=3;
        int totalSeats=6;
        for(int row=0;row<totalRows;row++)
        {
            for(int seat=0;seat<totalSeats;seat++)
            {
                System.out.println(String.format("row %d col %d Seat Row %s value %s",
                        row+1,seat+1,seats[row][seat].substring(0,1),seats[row][seat]));
            }
        }
    }
}
