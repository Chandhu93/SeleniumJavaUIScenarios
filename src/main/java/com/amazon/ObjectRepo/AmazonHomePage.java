package com.amazon.ObjectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.genericUtility.WebDriverUtility;

public class AmazonHomePage {
	
	 public AmazonHomePage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	
	@FindBy(xpath="//input[@placeholder='Search Amazon.in']")
	private WebElement searchBox;
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	
	
	@FindBy(xpath = "//button[text()='Continue shopping']")
	private WebElement continueShoppingBtn;
	
	public WebElement getcontinueShoppingBtn() {
		return continueShoppingBtn;
	}

	public void searchProduct(String product, WebDriverUtility wLib, WebDriver diver) {
//		wLib.visibilityOfEle(diver, getcontinueShoppingBtn());
//		getcontinueShoppingBtn().click();
		wLib.visibilityOfEle(diver, getSearchBox());
		getSearchBox().sendKeys(product, Keys.ENTER);
	}
}
