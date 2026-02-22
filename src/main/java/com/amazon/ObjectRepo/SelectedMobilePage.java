package com.amazon.ObjectRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.genericUtility.ExcelUtility;
import com.flipkart.genericUtility.WebDriverUtility;

public class SelectedMobilePage {

	public SelectedMobilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a/h2/span") 
	private List<WebElement> mobileNames;

	public List<WebElement> getMobileNames() {
		return mobileNames;
	}

	@FindBy(xpath="//a/span/span/span[@class='a-price-whole']") 
	private List<WebElement> prices;

	public List<WebElement> getPrices() {
		return prices;
	}


	@FindBy(xpath="//li//a[text()='Next']") 
	private WebElement nxtBtn;

	public WebElement getNxtBtn() {
		return nxtBtn;
	}

	public void nameAndPrice(WebDriver driver,  WebDriverUtility wLib, ExcelUtility eLib) throws IOException {
		int rowIndex = 0;
		for(int i=1; i<=4; i++) {
			List<WebElement> allName= getMobileNames();
			List<WebElement> allPrice = getPrices();

			for(int j = 0; j < allName.size()-1; j++) {
				String mbl = allName.get(j).getText();
				String price = allPrice.get(j).getText();

				System.out.println(mbl);
				System.out.println(price);

				System.out.println(mbl + " - " + price);

				eLib.writeDataBackToExcel("mobiles", rowIndex, 0, mbl);   
				eLib.writeDataBackToExcel("mobiles", rowIndex, 1, price); 

				rowIndex++;
			}

			wLib.actionPause(driver, 3000);
			wLib.visibilityOfEle(driver, nxtBtn);
			getNxtBtn().click();

		}
	}



}	




