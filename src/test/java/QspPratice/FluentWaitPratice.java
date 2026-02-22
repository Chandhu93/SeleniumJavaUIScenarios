package QspPratice;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

public class FluentWaitPratice {

	@Test
	public void test() {
		WebDriver driver= new ChromeDriver();
		FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(driver)
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofSeconds(2))
		.ignoring(NoSuchElementException.class);
		
		WebElement ele = driver.findElement(By.xpath(""));
		fwait.until(ExpectedConditions.visibilityOf(ele));
	}

}
