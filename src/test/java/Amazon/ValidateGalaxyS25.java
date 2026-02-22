package Amazon;

import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ValidateGalaxyS25 {
	@Test
	public void  ValidategalaxytS25Test() {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Galaxy S25", Keys.ENTER);
		//a/h2/span[contains(text(), 'iPhone')]
		List<WebElement> allPhone = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']/descendant::a/h2/span[contains(.,'Galaxy S25')]"));
		for(WebElement ele : allPhone) {
		String text = 	ele.getText(); 
		System.out.println(text+ "==PASS==");
		Assert.assertTrue(text.contains("Galaxy S25"), "Galaxy S25");
		
		}
		System.out.println("===PASS===");
		driver.quit();
	}

}
