package com.flipkart.genericUtility;

import java.io.IOException;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


public class BaseClass {

	public WebDriverUtility wLib = new WebDriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebDriver driver;

	@BeforeClass 
	public void beforeClass() throws IOException {

		String browser= fLib.readDataFromProperties("browser");

		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		wLib.maximizeWindow(driver);
		String url= fLib.readDataFromProperties("AmzUrl");
		driver.get(url);

	}

	@AfterClass
	public void configAC() {
		//driver.quit();
	}



}
