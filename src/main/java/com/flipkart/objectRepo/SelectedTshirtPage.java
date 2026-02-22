package com.flipkart.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.genericUtility.WebDriverUtility;

public class SelectedTshirtPage {
	public SelectedTshirtPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='You might be interested in']")
	private WebElement mightBeIntrestTxt;
	
	public WebElement getMightBeIntrest() {
		return mightBeIntrestTxt;
	}
	
	@FindBy(xpath= "//button[@class='QqFHMw vslbG+ In9uk2']")
	private WebElement addCartButton;
	
	public WebElement getAddCartButton() {
		return addCartButton;
	}
 	
	public void addTshirtToCart(WebDriver driver, WebDriverUtility wLib) {
		wLib.scrollToEle(driver, mightBeIntrestTxt);
		getAddCartButton().click();
	}
	
}









