package automation.Scenario1;

import java.time.Duration;
import java.util.List;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CountTheNameFromGooglePage {
	
	@org.testng.annotations.Test
	public static void nameCount() throws InterruptedException {
		
		// We cannot automate the captcha(I'm human) 
		
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		d.get("https://www.google.com/");
		d.findElement(By.name("q")).sendKeys("Dhoni", Keys.ENTER);
		
		Thread.sleep(18000);
		
		List<WebElement> ele = d.findElements(By.tagName("h3"));
		
		int count= ele.size();
		System.out.println(count);
	}
	

}
