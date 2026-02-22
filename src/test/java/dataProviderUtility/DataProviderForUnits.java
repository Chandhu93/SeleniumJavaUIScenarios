package dataProviderUtility;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderForUnits {
	
	@Test (dataProvider = "unitsAndDesp")
	public void unitsDataFromDataProviderTest(String units, String desp) {
		System.out.println(units + " --> " + desp);
	}
	
	@DataProvider (name = "unitsAndDesp")
	public Object[][] getUnits() {
		return new Object[][] {
			{"GSM","Grams Square Meter"},
			{"units","One piece one units"},
			{"Meters","For Fabric"}
		};
	}
	
}
