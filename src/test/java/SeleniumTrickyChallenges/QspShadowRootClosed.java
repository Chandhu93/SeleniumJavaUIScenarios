package SeleniumTrickyChallenges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class QspShadowRootClosed {
	@Test
	public void shadowRootClosed() throws Exception {
		WebDriver	driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//main/section[@id='optionsBody']/descendant::p[.='UI Testing Concepts']")).click();
		WebElement e1 = driver.findElement(By.xpath("//aside/descendant::section[.='Shadow Root Elements']"));
		act.scrollToElement(e1).click(e1).perform();
		driver.findElement(By.xpath("//div/descendant::section[.='Shadow Root']")).click();
		driver.findElement(By.xpath("//p[.='Actions']/following-sibling::ul/li[.='Close Shadow Root']")).click();
		
		By e2 = By.xpath("//form/div[@class='my-3'][1]");
		// here were passing the By.locator not the WebElement
		wait.until(ExpectedConditions.elementToBeClickable(e2)).click();
		
		act.sendKeys("admin").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("admin").perform();
		driver.findElement(By.xpath("//button[.='Login']")).click();
		driver.quit();
	}


	@Test
	public void shadowRootOpen() throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		driver.get("https://demoapps.qspiders.com/");
		driver.findElement(By.xpath("//main/section[@id='optionsBody']/descendant::p[.='UI Testing Concepts']")).click();
		WebElement e1 = driver.findElement(By.xpath("//aside/descendant::section[.='Shadow Root Elements']"));
		act.scrollToElement(e1).click(e1).perform();
		driver.findElement(By.xpath("//div/descendant::section[.='Shadow Root']")).click();
		WebElement host = driver.findElement(By.xpath("//div[@class='my-3'][1]"));
		SearchContext ele = host.getShadowRoot();
		ele.findElement(By.cssSelector("input[type='text']")).sendKeys("admin");
		WebElement host1 = driver.findElement(By.xpath("//div[@class='my-3'][2]"));
		SearchContext e2 = host1.getShadowRoot();
		e2.findElement(By.cssSelector("input[type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[.='Login']")).click();
		driver.quit();
	}
}
