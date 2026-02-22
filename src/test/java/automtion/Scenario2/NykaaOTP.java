package automtion.Scenario2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NykaaOTP {
	@Test
	public void otp() {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		WebElement e1 = driver.findElement(By.xpath("//input[@label='Mobile Number']"));
		//e1.click();
		e1.sendKeys("9848012345", Keys.ENTER);
		driver.findElement(By.xpath("//button[text()='Send OTP']")).click();
		driver.findElement(By.xpath("//button[text()='Create a new account']")).click();
		
		List<WebElement> lst = driver.findElements(By.xpath("//input[@type='tel']"));
		
//		for(WebElement l: lst) {
//			l.sendKeys(Keys.NUMPAD1);
//		}
		
		for(int i=0; i<lst.size(); i++) {
			Keys k = Keys.valueOf("NUMPAD" +(i+1));
			lst.get(i).sendKeys(k);
		}
		String txt =driver.findElement(By.xpath("//div[@class='css-m371yn']")).getText();
		System.out.println(txt);
	}
	

}










