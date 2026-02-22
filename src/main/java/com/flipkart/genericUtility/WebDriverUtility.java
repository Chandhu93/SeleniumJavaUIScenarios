package com.flipkart.genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	String parentWid;
	
	public void scrollToEle(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.scrollToElement(ele).perform();
	}
	
	public void actionPause(WebDriver driver, long time) {
		Actions a = new Actions(driver);
		a.pause(time).perform();
	}
	
	public void visibilityOfEle(WebDriver driver, WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void moveOnElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void switchToTab (WebDriver driver) {
		parentWid =driver.getWindowHandle();
		Set<String> allWId = driver.getWindowHandles();
		for (String wId :  allWId) {
			if(wId != parentWid) {
				driver.switchTo().window(wId);
			}
		}
	}
	
	public void getParentWid(WebDriver driver) {
		driver.switchTo().window(parentWid);
	}
	

}
