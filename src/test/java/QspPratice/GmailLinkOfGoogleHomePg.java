package QspPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GmailLinkOfGoogleHomePg {
	
	@Test
	public void gmailLink() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String link=driver.findElement(By.xpath("//a[text()='Gmail']")).getAttribute("href");
		System.out.println(link);
		driver.quit();
	}

}
