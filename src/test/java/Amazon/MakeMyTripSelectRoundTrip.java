package Amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MakeMyTripSelectRoundTrip {

	@Test
	public void roundTrip() throws InterruptedException {
		
		String date = "Mar 23 2026";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		JavascriptExecutor js = ( JavascriptExecutor) driver;
		
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();		
		driver.findElement(By.xpath("//img[@alt=\"minimize\"]")).click();		
		WebElement flightIcon=  driver.findElement(By.xpath("//li[@data-cy=\"menu_Flights\"]"));		
		wait.until(ExpectedConditions.elementToBeClickable(flightIcon));
		flightIcon.click();
		driver.findElement(By.xpath("//img[@alt=\"minimize\"]")).click();		
				
		WebElement rt = driver.findElement(By.xpath("//li[.='Round Trip']"));
		js.executeScript("arguments[0].click();", rt);
		
		WebElement dep = driver.findElement(By.xpath("//label[@for='departure']"));
		js.executeScript("arguments[0].click();", dep);
		
		WebElement depDate = driver.findElement(By.xpath("//div[@class='datePickerContainer']/descendant::div[contains(@aria-label,'"+date+"')]"));
		js.executeScript("arguments[0].click();", depDate);
		
		WebElement ret = driver.findElement(By.xpath("//label[@for='departure']/parent::div/following-sibling::div/div[@data-cy='returnArea']"));
		js.executeScript("arguments[0].click();", ret);
		
		WebElement retDate= driver.findElement(By.xpath("//div[@class='datePickerContainer']/descendant::div[contains(@aria-label,'"+date+"')]"));
		js.executeScript("arguments[0].click();", retDate);
		driver.findElement(By.xpath("//a[.='Search']")).click();
		
		Thread.sleep(9000);
		driver.quit();
		
	}
}
