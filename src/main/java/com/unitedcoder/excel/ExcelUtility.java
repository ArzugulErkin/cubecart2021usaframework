package com.unitedcoder.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.List;

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
    public void writeToExcelFileMultipleCells(String fileName, String sheetName, List<String> contents)
    {
        //define a file to write
        File excelFile=new File(fileName);  //we create a file object instance
        //define a workbook
        XSSFWorkbook workbook=new XSSFWorkbook();
        //add worksheet to the workbook
        XSSFSheet sheet= workbook.createSheet(sheetName);
        //define rows in the worksheet
        int numberOfRows=contents.size();
        for(int rowNumber=0;rowNumber<numberOfRows; rowNumber++)
        {
            XSSFRow row=sheet.createRow(rowNumber); //add row to the sheet
            String[] rowContent=contents.get(rowNumber).split(",");  //separating content with comma
            int totalCells=rowContent.length;
            for(int cellNumber=0;cellNumber<totalCells;cellNumber++)
            {
                XSSFCell cell=row.createCell(cellNumber); //add cell to the row
                //add value to the cell
                cell.setCellValue(rowContent[cellNumber]);

                if(rowContent[cellNumber].equalsIgnoreCase("passed"))
                {
                    XSSFCellStyle style=workbook.createCellStyle();
                    style.setFillForegroundColor(IndexedColors.GREEN.getIndex()); //set cell color to green
                    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cell.setCellStyle(style);
                }
            }

        }
        //define output stream to write a file to the disk
        FileOutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(excelFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
