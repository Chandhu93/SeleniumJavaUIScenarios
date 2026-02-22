package SampleBaseClass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Open Browser");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("Close Browser");
	}
}
