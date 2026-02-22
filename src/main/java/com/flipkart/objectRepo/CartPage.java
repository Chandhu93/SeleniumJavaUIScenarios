package com.flipkart.objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.genericUtility.JavaUtility;
import com.flipkart.genericUtility.WebDriverUtility;

public class CartPage  {
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='+']")
	private WebElement pluseBtn;
	
	public WebElement getPluseBtn() {
		return pluseBtn;
	}
	
	@FindBy(xpath="//span[@class='LAlF6k re6bBo']")
	private WebElement price;
	
	public WebElement getPrice() {
		return price;
	}
	
	@FindBy(xpath="//div[@class='WH+Ng1']//span")
	private WebElement totalPrice;
	
	public WebElement getTotalPrice() {
		return totalPrice;
	}
	
	public void clickPluseBtn(WebDriver driver, WebDriverUtility wLib) {
		wLib.visibilityOfEle(driver, pluseBtn);
		getPluseBtn().click();
	}
	
	public int priceInInt (WebDriver driver, WebDriverUtility wLib, JavaUtility jLib) {
		wLib.actionPause(driver, 3000);
		wLib.visibilityOfEle(driver, getPrice());
		String s =getPrice().getText();
		int p =jLib.StringToIntParse(s);
		return p+4;
	}
	
	public int totalpriceInInt (WebDriver driver, WebDriverUtility wLib, JavaUtility jLib) {
		wLib.actionPause(driver, 3000);
		wLib.visibilityOfEle(driver, getTotalPrice());
		String s =getTotalPrice().getText();
		int tp =jLib.StringToIntParse(s);
		return tp;
	}
}








