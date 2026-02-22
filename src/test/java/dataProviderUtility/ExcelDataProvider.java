package dataProviderUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	@DataProvider
	public Object[][] readDataFromExcel() throws  IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\eleconSCM_TestData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis); 
		
		Sheet sheet = wb.getSheet("retailerPurchaseOrderData");
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		DataFormatter df = new DataFormatter();	// From apachi poi to get every data as String
		Object[][] data = new Object[rowCount][colCount];
		
		for(int i=1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			
			for(int j=0; j<colCount; j++) {	// first iteration i-1 = 0, 0th index of Object[0][0]	
				data [i-1] [j] = df.formatCellValue(row.getCell(j)); 
			}
		}
		wb.close();
		return data;
	}
	
	

}
