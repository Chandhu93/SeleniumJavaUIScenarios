package AutomationExePageScenario;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SliderPriceRange {
	@Test
	public void slider() {
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 1900);");
		
		WebElement s1 = driver.findElement(By.xpath("//div[@id='slider-range']/span[@style='left: 15%;']"));
		s1.click();
		for(int i=80; i>=0; i--) {
			s1.sendKeys(Keys.ARROW_LEFT);
		}
		
		WebElement s2 = driver.findElement(By.xpath("//div[@id='slider-range']/span[@style= 'left: 60%;'][position()=1]"));
		s2.click();
		for(int i=60; i<=260; i++) {
			s2.sendKeys(Keys.ARROW_RIGHT);
		}
		String price= driver.findElement(By.xpath("//p/input[@id='amount']")).getAttribute("value");
		System.out.println(price);
	}	

}














