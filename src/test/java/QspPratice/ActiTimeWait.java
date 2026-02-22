package QspPratice;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ActiTimeWait {
	
	@Test
	public void actiTimeCustomWait() {
		WebDriver driver =new ChromeDriver();
		driver.get("https://online.actitime.com/asandeep");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='login']")).click();
		
		int i= 0;
		while (i<=50) {
			try {
				driver.findElement(By.id("logoutLink")).click();
				break;
			}
			catch (NoSuchElementException e) {
				i++;
			}
		}
	}
	
	@Test
	public void actiTimeExplicitWait() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://online.actitime.com/asandeep");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='login']")).click();
		driver.findElement(By.id("logoutLink")).click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Enter"));
		String title = driver.getTitle();
		System.out.println(title);
	}
}
