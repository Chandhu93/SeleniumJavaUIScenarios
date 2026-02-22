package automtion.Scenario2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RedBusSetAvailability {
	@Test
	public void seat() throws InterruptedException {
		
		String src="Banglaore";
		String dest="Vijayawada";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		//div[@class='srcDestWrapper___bc5ef1']
		
		WebElement ele = driver.findElement(By.xpath("//div[text()='From']"));
		ele.click();
		
		WebElement e1 = driver.findElement(By.xpath("//div[@class='suggestionsWrapper___440585']/descendant::div[text()='Bangalore']"));		
		e1.click();
	
		WebElement e2 = driver.findElement(By.xpath("//div[text()='To']"));
		wait.until(ExpectedConditions.visibilityOf(e2));
		e2.click();
		
		WebElement e3 = driver.findElement(By.xpath("//div[@class='searchSuggestionWrapper___b4b282']/descendant::div[text()='Vijayawada']"));		
		e3.click();
		
		//driver.quit();
	}
	
}







