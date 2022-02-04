package com.unitedcoder.excel;

import java.util.ArrayList;
import java.util.List;

public class ExcelWriteDemo1 {
    public static void main(String[] args) {

        List<String> testReports=new ArrayList<>();
        testReports.add("TestName,TestModule,TestStatus,ExecutedAt,ExecutedBy");
        testReports.add("Login,Login,Passed,2022-02-03 20:32:15,Dolkun");
        testReports.add("Add Customer,Customer,Passed,2022-02-03 20:34:40,Tarim");
        testReports.add("Add Product,Inventory,Failed,2022-02-03 20:34:90, Dilmurat");
        testReports.add("Update Product,Inventory,Passed,2022-02-03 20:46:80, Tarim");
        testReports.add("Logout,Login,Passed,2022-02-03 20:35:60,Dilmurat");

        ExcelUtility excelUtility=new ExcelUtility();
        String fileName="doc\\test-result"+System.currentTimeMillis()+".xlsx";
        excelUtility.writeToExcelFileMultipleCells(fileName,"functional1",testReports);

    }
}
