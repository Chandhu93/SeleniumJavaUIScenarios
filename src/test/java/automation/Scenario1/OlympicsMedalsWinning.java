package automation.Scenario1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OlympicsMedalsWinning { 
	@Test
	public void medalWinningCountries() {

		String sport="Boxing";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.bbc.com/sport/olympics/paris-2024/medals");
		driver.findElement(By.xpath("//span[text()='Medal results']")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@id='discipline-selector']"));
		
		Select s = new Select(ele);
		s.selectByVisibleText(sport);
		System.out.println("Medal Winning countries");
		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='ssrcss-1xzbuw5-SecondaryName e1dg50ic0']"));
		for(WebElement e : countries) {
			System.out.println(e.getText());
		}
		
		driver.quit();
	}
}
















