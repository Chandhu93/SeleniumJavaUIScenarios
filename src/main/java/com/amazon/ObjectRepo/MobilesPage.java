package com.amazon.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.genericUtility.WebDriverUtility;

public class MobilesPage {
	
	public MobilesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Redmi']")
	private WebElement selectMobileBrand;
	
	public WebElement getSelectMobile() {
		return selectMobileBrand;
	}
	
	public void selectBrand(WebDriver driver, WebDriverUtility wLib) {
		wLib.visibilityOfEle(driver, getSelectMobile());
		getSelectMobile().click();
	}
}
