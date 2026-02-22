package automation.Scenario1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ICCTestRanking {
	@Test
	public void testRating() {
		String country ="India";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.bcci.tv/international/men/rankings/test");
		
		String rating = driver.findElement(By.xpath("//h6[text()='"+country+"']/ancestor::tr/td[span[text()='Ratings']]/p")).getText();
		
		System.out.println(country+": "+rating);
		driver.quit();
	}
}
















