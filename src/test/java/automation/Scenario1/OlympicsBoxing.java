package automation.Scenario1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OlympicsBoxing {
	@Test
	public void boxing() throws InterruptedException {
		String s = "Men's Light Heavy (75-81kg)";
		String player= "Arlen LOPEZ";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.olympics.com/en/olympic-games/tokyo-2020");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();

		driver.findElement(By.linkText("Results")).click();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0, 1200);");
		
		driver.findElement(By.xpath("//a/p[text()='Boxing']")).click();
		j.executeScript("window.scrollBy(0, 400);");
		driver.findElement(By.xpath("//span[text()='Event']")).click();
		
		driver.findElement(By.xpath("//button[.//p[text()=\"" + s + "\"]]")).click();
		driver.findElement(By.xpath("//span[text()='Go']")).click();
		j.executeScript("window.scrollBy(0, 1200);");
		
		String play = driver.findElement(By.xpath("//h3[text()='"+player+"']")).getText();
		String country = driver.findElement(By.xpath("//h3[text()='"+player+"']/ancestor::div[@data-cy='single-athlete-result-row']/div[@data-cy='flag-row-1']//span")).getText();
		
		System.out.println(play);
		System.out.println(country);
		driver.quit();
	}

}













