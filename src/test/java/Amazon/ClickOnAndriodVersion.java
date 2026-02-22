package Amazon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.mysql.cj.protocol.a.TracingPacketReader;

public class ClickOnAndriodVersion {
	
	@Test
	public void andriodVersion13() throws InterruptedException {
		
		String osVer = "Android 13.0";
		String brand = "Samsung";
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		Actions act = new Actions(driver);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("phone", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='"+brand+"']")).click();
		WebElement os =  driver.findElement(By.xpath("//span[text()='"+osVer+"']/preceding-sibling::div/descendant::i"));
		act.moveToElement(os).perform();
		Thread.sleep(5000);
		os.click();
		Thread.sleep(5000);
		driver.quit();
	}

}
