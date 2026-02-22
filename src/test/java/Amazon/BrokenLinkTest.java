package Amazon;

import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinkTest {
	@Test
	public void brokenLinkTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		
		driver.get("https://www.indiapost.gov.in/");
		List<WebElement> allLink = driver.findElements(By.xpath("//a"));
		
		System.out.println(allLink.size());
		for(WebElement lk : allLink) {
			String link = lk.getAttribute("href");
			
			try {
				URL url = new URL(link);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				int statusCode = con.getResponseCode();
				if(statusCode >= 400) {
					System.out.println(link +" --> "+ (statusCode));
				}
			}
			catch (Exception e) {
				
			}
		}
		driver.quit();
	}
}
