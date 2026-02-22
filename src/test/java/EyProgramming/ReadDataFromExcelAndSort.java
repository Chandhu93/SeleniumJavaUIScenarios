package EyProgramming;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelAndSort {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./ExternalResourceFolder/NamesList.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int col = wb.getSheet("names").getLastRowNum();
		String[] arr = new String[col+1];
		for(int i=0; i<=col; i++) {
			String data= wb.getSheet("names").getRow(i).getCell(0).getStringCellValue();
			//System.out.println(data);
			for(int j=0; j<arr.length; j++) {
				if(arr[j]== null) {
					arr[j]=data;	
					break;
				}
			}
		}
		wb.close();
		System.out.println(Arrays.toString(arr));
		
		String[] sortArr = arr.clone();
		for (int i = 0; i < sortArr.length - 1; i++) {
		    for (int j = i + 1; j < sortArr.length; j++) {
		        if (sortArr[i].compareTo(sortArr[j]) > 0) {  
		            String temp = sortArr[i];
		            sortArr[i] = sortArr[j];
		            sortArr[j] = temp;
		        }
		    }
		}
		System.out.println(Arrays.toString(sortArr));
		//compare two arrays
		for(int i=0; i<arr.length; i++) {
				if(arr[i].equals(sortArr[i])) {
					System.out.println("Array is not sorted");
					break;
			}
				else { 
					System.out.println("Array is Sorted");
					break;
				}
		}
		
	}
}
