package com.flipkart.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.genericUtility.WebDriverUtility;

public class ProductPage {

	WebDriverUtility wLib = new WebDriverUtility();
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//span[text()='Men']")
	private WebElement menCategory;
	
	public WebElement getMenCat() { 
		return menCategory;
	}
	
	@FindBy(xpath= "//div/a[text()='T-Shirts']")
	private WebElement tShirtSection;
	
	public WebElement getTShirtSection() { 
		return tShirtSection;
	}
	
	public void clickTShirtSection(WebDriver driver, WebDriverUtility wLib) {
		wLib.moveOnElement(driver, menCategory);
		wLib.visibilityOfEle(driver, getTShirtSection());
		getTShirtSection().click();
		
	}
	

}
