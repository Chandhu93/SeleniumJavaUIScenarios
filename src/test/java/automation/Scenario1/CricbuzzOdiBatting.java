package automation.Scenario1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CricbuzzOdiBatting {
	
	@Test
	public void rank() {
		String player = "Travis Head";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.id("rankingDropDown")).click();
		driver.findElement(By.id("batsmen-odis-tab")).click(); 
		
		String rating = driver.findElement(By.xpath("//div[contains(@ng-show, 'batsmen-odis')]/descendant::a[text()='"+player+"']/parent::div/parent::div/following-sibling::div")).getText();
		String country= driver.findElement(By.xpath("//a[text()='"+player+"']/following-sibling::div")).getText();
		System.out.println(rating);
		System.out.println(country);
		driver.quit();
	}

}
