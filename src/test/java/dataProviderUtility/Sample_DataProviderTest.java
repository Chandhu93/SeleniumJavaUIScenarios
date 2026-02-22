package dataProviderUtility;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample_DataProviderTest {
	
	@Test (dataProvider = "getData")
	public void createContactTest(String firstName, String lastName, long phoNum) {
		System.out.println("FirstName: "+firstName+" LastName: "+lastName+" PhoneNum: "+phoNum );
	}
	
	
	@DataProvider
	public Object [][] getData() {
		Object[][] a = new Object[3] [3];
		
		a[0][0] = "Hari";
		a[0][1] = "Haran";
		a[0][2] = 987654321;
		
		a[1][0] = "Siva";
		a[1][1] = "Rama";
		a[1][2] = 908765432;
		
		a[2][0] = "Ram";
		a[2][1] = "Krishna";
		a[2][2] = 980765432;
		
		return a;
	}
	
	
}
