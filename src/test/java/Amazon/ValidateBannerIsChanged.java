package Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateBannerIsChanged {

	@Test
	public void bannerTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
										// 	if aria-hidden = true --> banner is hidden								
		String b1 = driver.findElement(By.xpath("//div[@cel_widget_id='desktop-hero-order']/descendant::li[@aria-hidden='false']/descendant::img")).getAttribute("alt");
		System.out.println(b1);
		Thread.sleep(9000);
		String b2 =driver.findElement(By.xpath("//div[@cel_widget_id='desktop-hero-order']/descendant::li[@aria-hidden='false']/descendant::img")).getAttribute("alt");
        System.out.println(b2);
		
		Assert.assertNotEquals(b1, b2);
		driver.quit();
	}
}
