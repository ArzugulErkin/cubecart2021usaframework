package com.unitedcoder.excel;

public class ExcelReadDemo1 {
    public static void main(String[] args) {
     ExcelUtility excelUtility=new ExcelUtility();
     String username= excelUtility.readExcelCell("doc\\cubecart-login.xlsx","Sheet1",1,0);
     String password=excelUtility.readExcelCell("doc\\cubecart-login.xlsx","Sheet1",1,1);
     String userRole=excelUtility.readExcelCell("doc\\cubecart-login.xlsx","Sheet1",1,2);
        System.out.println(String.format("%s   %s    %s",username,password,userRole));
    }
}
