package com.flipkart.objectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {
	
	public FlipkartHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div/input[@name='q']")
	private WebElement searchBox;
	
	public WebElement getSearchBox() {
		return searchBox;
	}
	
	public void searchProduct(String product) {
		getSearchBox().sendKeys(product, Keys.ENTER);
	}
	
}
