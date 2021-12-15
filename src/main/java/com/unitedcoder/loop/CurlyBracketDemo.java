package com.unitedcoder.loop;

public class CurlyBracketDemo {
    public static void main(String[] args) {
        String s = "Test Automation";
        if (s.contains("test")) {
            System.out.println("true");
        } else {
            System.out.println(false);
        }

        //I will improve the code block in the future
        // To: do
        {
            System.out.println("code block 1");
            System.out.println("code block 2");
        }
    }
}
