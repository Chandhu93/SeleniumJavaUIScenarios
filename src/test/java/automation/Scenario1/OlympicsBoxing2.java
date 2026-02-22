package automation.Scenario1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OlympicsBoxing2 {

	@Test
	public void oly() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.olympics.com/en/olympic-games/tokyo-2020");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		driver.get("https://www.olympics.com/en/olympic-games/tokyo-2020");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();

		driver.findElement(By.linkText("Results")).click();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0, 1200);");

		driver.findElement(By.xpath("//p[text()='Boxing']")).click();
		driver.findElement(By.xpath("//span[text()='Event']")).click();
		driver.findElement(By.xpath("//div[@class='sc-d0fd8f2b-3 oxuPj']/span[text()='Tokyo 2020']")).click();
		driver.findElement(By.xpath("//p[text()='Beijing 2022']")).click();
		driver.findElement(By.xpath("//span[text()='Discipline']")).click();

		String game = "Alpine Skiing";
		driver.findElement(By.xpath("//p[text()='"+game+"']")).click();
		driver.findElement(By.xpath("//span[text()='Event']")).click();

		String partialtext = "s Super-G";

		driver.findElement(By.xpath("//p[contains(text(),'"+partialtext+"')]")).click();
		driver.findElement(By.xpath("//span[text()='Go']")).click();

		String name = "Trevor PHILP";
		j.executeScript("window.scrollBy(0,1500);");
		String country = driver.findElement(By.xpath("//h3[text()='"+name+"']/ancestor::div[@class='sc-4ffa8ad5-4 gKRjTb']/preceding-sibling::div[@class='sc-4ffa8ad5-1 eimYXX']/div/span")).getText();
		System.out.println("Player: " + name+", Country: " + country);

		driver.quit();
	}
}