package Concepts;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class OpenNewWindowGetTitle {
	
	@Test
	public void newWindow() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = (String) js.executeScript("return document.title;");
		String url  = (String) js.executeScript("return document.URL;");
		
		System.out.println(title);
		System.out.println(url);
		
		Actions act = new Actions(driver);
		act.pause(Duration.ofSeconds(3)).perform();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		String t1 = (String) js.executeScript("return document.title;");
		String u1 = (String) js.executeScript("return document.URL;");
		System.out.println(t1);
		System.out.println(u1);
		
		driver.quit();
	}
	
	@Test
	public void newTab() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = (String) js.executeScript("return document.title;");
		String url  = (String) js.executeScript("return document.URL;");
		System.out.println(title);
		System.out.println(url);
		
		// Thread.sleep(4000);
		Actions act = new Actions(driver);
		act.pause(Duration.ofSeconds(3)).perform();
		
		driver.switchTo().newWindow(WindowType.TAB); 
		//No need to switch control will present on new tab because opened new tab directly
		driver.get("https://www.flipkart.com/");
		String t1 = (String) js.executeScript("return document.title;");
		String u1 = (String) js.executeScript("return document.URL;");
		System.out.println(t1);
		System.out.println(u1);
		
		driver.quit();
	}

}
