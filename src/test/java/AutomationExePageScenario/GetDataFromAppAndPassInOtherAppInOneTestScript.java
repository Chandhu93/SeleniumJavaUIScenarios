package AutomationExePageScenario;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GetDataFromAppAndPassInOtherAppInOneTestScript {
	@Test
	public void getTextAndPassInOtherApplicationTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='totalAmount']"));
		Actions act = new Actions(driver);
		act.scrollToElement(ele);
		String text = driver.findElement(By.xpath("//div//div[@class='tableFixHead']/table/tbody/tr/td[.='Raymond']")).getText();
		System.out.println(text);
		
		// Opening new tab
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(text, Keys.ENTER);
		driver.quit();
	}
}
