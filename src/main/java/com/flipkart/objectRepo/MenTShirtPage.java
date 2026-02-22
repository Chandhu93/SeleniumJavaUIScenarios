package com.flipkart.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.genericUtility.WebDriverUtility;

public class MenTShirtPage {
	
	public MenTShirtPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy( xpath= "//div[text()='Brand']")
	private WebElement brandDD;
	
	public WebElement getBrandDD() {
		return brandDD;
	}
	
	@FindBy(xpath="//div[text()='PUMA']")
	private WebElement pumaCheckBox;
	
	public WebElement getPumaCheckBox() {
		return pumaCheckBox;
	}
	
	@FindBy(xpath = "//div//a[text()='2']")
	private WebElement secondPageBtn;
	
	public WebElement getSecondPageBtn() {
		return secondPageBtn;
	}
	
	@FindBy(xpath= "//div[@class='_1sdMkc LFEi7Z']")
	private WebElement tShirt;
	
	public WebElement getTShirt() {
		return tShirt;
	}
	
	@FindBy(xpath= "//span[text()='Price']")
	private WebElement priceEle;
	
	public WebElement getPriceEle() { 
		return priceEle;
	}
	
	public void selectTshirt(WebDriver driver, WebDriverUtility wLib) {
		wLib.visibilityOfEle(driver, getPriceEle());
		wLib.scrollToEle(driver, getBrandDD());
		getBrandDD().click();
		getPumaCheckBox().click();
		wLib.scrollToEle(driver, getSecondPageBtn());
		getSecondPageBtn().click();
		wLib.actionPause(driver, 6000);
		wLib.visibilityOfEle(driver, getTShirt());
		getTShirt().click();
	}
	
	@FindBy(xpath="//div[@class='cjMG1q']")
	private WebElement cartBtn;
	
	public WebElement getCartBtn() {
		return cartBtn;
	}
	
	public void clickCartBtn() {
		getCartBtn().click();
	}
	
}









