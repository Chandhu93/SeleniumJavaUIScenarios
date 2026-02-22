package automtion.Scenario2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CarDheko {
	
	@Test
	public void carVarient() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.cardekho.com/");
		WebElement newCar= driver.findElement(By.xpath("//span[text()='NEW CARS ']"));
//		Actions a = new Actions(driver);
//		a.moveToElement(newCar);
		newCar.click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//ul/li/a/span[.='Explore New Cars']"));
		wait.until(ExpectedConditions.elementToBeClickable(newCar)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 500)");
		
		System.out.println("End");
		//driver.quit();
	}
}














