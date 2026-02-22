package automation.Scenario1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CricbuzzBowler {
	@Test
	public void rank() {
		String player = "Kuldeep Yadav";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.id("rankingDropDown")).click();
		driver.findElement(By.linkText("Bowling")).click();
		driver.findElement(By.id("bowlers-odis-tab")).click(); 
		String name = driver.findElement(By.xpath("//a[text()='"+player+"']")).getText();
		String rating = driver.findElement(By.xpath("//a[text()='"+player+"']/parent::div/parent::div/following-sibling::div")).getText();
		String country= driver.findElement(By.xpath("//a[text()='"+player+"']/following-sibling::div")).getText();
		System.out.println(name);
		System.out.println(rating);
		System.out.println(country);
		driver.quit();
	}
}
