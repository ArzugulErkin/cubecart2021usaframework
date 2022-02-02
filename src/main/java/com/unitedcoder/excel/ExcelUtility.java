package com.unitedcoder.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {
    public String readExcelCell(String fileName,String sheetName,int rowNumber,int cellNumber)
    {
        String cellValue=null;
        //read a File using file input stream
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //open the file as an Excel file
        XSSFWorkbook workbook=null;
        try {
            workbook=new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //read a sheet from the Excel file - get a worksheet from an Excel file
        XSSFSheet sheet=workbook.getSheet(sheetName);
        //get rows from the worksheet
        XSSFRow row=sheet.getRow(rowNumber);
        //get the cell from the row
        if(row==null)
        {
            System.out.println("Empty row, no data is available in the excel sheet");
        }
        else {
            XSSFCell cell=row.getCell(cellNumber);
            CellType cellType=cell.getCellType(); //reading the content type in the cell
            switch (cellType){
                case NUMERIC:
                    cellValue=String.valueOf(cell.getNumericCellValue());
                    break;
                case STRING:
                    cellValue=cell.getStringCellValue();
                    break;
                default:
                    cellValue=cell.getStringCellValue();
                    break;
            }
        }

        return cellValue;
    }
}
