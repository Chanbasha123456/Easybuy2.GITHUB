package com.easybuy.readexcel;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Excel {

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\LENOVO'\\eclipse-workspace\\easybuy_AT\\src\\test\\resources\\Testdata\\login.xlsx");
		FileInputStream fi= new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		XSSFSheet sheet = wb.getSheetAt(0);
	    int rows =	sheet.getPhysicalNumberOfRows();
	    System.out.println(rows);
       int columns = sheet.getRow(0).getLastCellNum();
       System.out.println(columns);
       for(int i=1; i<rows;i++)
       {
    	   for(int j=0; j<columns;j++)
    	   {
    		   String celldata = sheet.getRow(i).getCell(j).getStringCellValue();
    		   System.out.print(celldata+" ");
    	   }
    	   System.out.println();
    	   
       }
	}
	

}
