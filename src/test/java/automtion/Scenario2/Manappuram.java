package automtion.Scenario2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Manappuram { 
	@Test
	public void rank() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.manappuram.com/gold-loan-calculator");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0, 2000);");
		driver.findElement(By.id("edit-username")).sendKeys("Ram");
		driver.findElement(By.id("edit-phone-number")).sendKeys("9848012345");
		driver.findElement(By.id("edit-email")).sendKeys("ram@gmail.com");
		driver.findElement(By.id("edit-city")).sendKeys("Bengaluru");
		driver.findElement(By.id("edit-gold-weight")).sendKeys("10");
		driver.findElement(By.id("edit-amount-required")).sendKeys("1");
		driver.findElement(By.id("select2-edit-state-container")).click();
		driver.findElement(By.xpath("//li[text()='Andhra Pradesh']")).click();
		driver.findElement(By.xpath("//span[text()='Gold Type']")).click();
		driver.findElement(By.xpath("//li[text()='Chain']")).click();
		
		driver.findElement(By.xpath("//button[text()='Calculate']")).click();
		j.executeScript("window.scrollBy(0, 1500);");
		String texxt=driver.findElement(By.xpath("//div[@role='status']")).getText();
		System.out.println(texxt);
		driver.quit();


	}
}







