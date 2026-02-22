package dataProviderUtility;

import org.testng.annotations.Test;

public class DataProviderTest {
			// outside of class provide class name
	@Test ( dataProviderClass = ExcelDataProvider.class, dataProvider = "readDataFromExcel")
	public void dataFromExcelTest(String sellerId, String billingAddress, String shippingAddress, String productCategory, 
			String productName, String qty, String dateOfDelivery, String paymentTerm) {
		
		 System.out.print(sellerId+ " \t ");
		 System.out.print(billingAddress+ " \t ");
		 System.out.print(shippingAddress+ " \t ");
		 System.out.print(productCategory+ " \t ");
		 System.out.print(productName+ " \t ");
		 System.out.print(Integer.parseInt(qty)+ " \t "); //making as int 
		 System.out.print(dateOfDelivery+ " \t ");
		 System.out.print(paymentTerm);
		 System.out.println();
		 System.out.println("-----------------------------");  // next line after 
		
	}
	
	
	
	
}

