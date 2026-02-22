package automation.Scenario1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ICCT20Ranking {
	@Test
	public void t20Rating() {
		String first ="India"; // first rank country
		String country ="Australia";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.bcci.tv/international/men/rankings/test");
		driver.findElement(By.xpath("//button[text()='T20I']")).click();
//		String r= driver.findElement(By.xpath("//span[text()='"+first+"']/ancestor::div[@class='trw-right']/div//td/span[text()='Rating']/following-sibling::p")).getText();
//		System.out.println(first+": "+r);
		
		String ele= driver.findElement(By.xpath("//h6[text()='"+country+"']/ancestor::tr/td/p/following-sibling::span[text()='Ratings']")).getText();
		System.out.println(country+": "+ele);
		
		driver.quit();
	}
}










