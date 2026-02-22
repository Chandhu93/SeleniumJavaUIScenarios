package com.flipkart.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtility {
	
	public String readDataFromExcel(String sheetName, int rowNum, int cell) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/flipkart.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cell).toString();
		return data;
	}

	public int getLastRowNum(String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/flipkart.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet(sheetName).getLastRowNum();
		return lastRowNum;
	}
	
	public void writeDataBackToExcel(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/flipkart.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet =  wb.getSheet(sheetName);
	    if (sheet == null) {
	        sheet = wb.createSheet(sheetName); // Create sheet if it doesn't exist
	    }

	    Row row = sheet.getRow(rowNum);
	    if (row == null) {
	        row = sheet.createRow(rowNum);     // Create row if it doesn't exist
	    }

	    Cell cell = row.getCell(cellNum);
	    if (cell == null) {
	        cell = row.createCell(cellNum);    // Create cell if it doesn't exist
	    }
	    
	    cell.setCellValue(data);

	    fis.close();
	    FileOutputStream fos = new FileOutputStream("./src/test/resources/flipkart.xlsx");
	    wb.write(fos);
	    wb.close();
	    fos.close();
	}
	
}










