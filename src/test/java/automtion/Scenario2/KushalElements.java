package automtion.Scenario2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KushalElements {
	@Test
	public void elements() {
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.kushals.com/");
		driver.findElement(By.xpath("//div[@class='wzrk-alert wiz-show-animate']/descendant::button[.='No thanks']")).click();
		
		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='main-nav']/div/div/ul/li/a[@class='navigation__link']"));
		for(WebElement e:ele) {	
			System.out.println(e.getText());
		}
		
		driver.close();
	}
}










