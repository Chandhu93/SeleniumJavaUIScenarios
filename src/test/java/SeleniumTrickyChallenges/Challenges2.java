package SeleniumTrickyChallenges;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Challenges2 {
	@Test
	public void dragAndDrop() {
		WebDriver	driver= new ChromeDriver();
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		WebElement src = driver.findElement(By.xpath("//div[@class='draggable']"));
		WebElement dest = driver.findElement(By.xpath("//div[@class='dropzone']"));
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}

	@Test
	public void contextClick() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		WebElement ele =driver.findElement(By.xpath("//div[@id='ctx-target']"));
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
		driver.findElement(By.xpath("//button[@id='ctx-inspect']")).click();	
	}

	@Test
	public void hiddenElement() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		driver.findElement(By.xpath("//button[@id='slide-in']")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.id("slide-target")));
	}

	@Test
	public void infinateScroll() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500);");
		WebElement area=driver.findElement(By.id("scroll-area"));
		Actions a = new Actions(driver);
		a.moveToElement(area).perform();
		WebElement ele =null;
		for(int i=0; i<=60;i++) {
			try {
				ele = area.findElement(By.xpath(".//div[.='Item #50']"));
				break;
			}
			catch (NoSuchElementException e) {
				js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 500;", area);
				Thread.sleep(2000);
			}
		}
	}
	
	@Test
	public void alert() throws InterruptedException  {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500);");
		driver.findElement(By.id("open-modal")).click();
		Thread.sleep(1000);
		Alert alt =  driver.switchTo().alert();
		alt.accept();
		driver.findElement(By.id("modal-close")).click();
	}
	
	 
}
