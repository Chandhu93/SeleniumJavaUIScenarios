package automation.Scenario1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenNewWindow {
	
	@Test
	public void useJSExecutor() {
		WebDriver	driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.open()");
		driver.get("https://google.com"); //control present in old window
	}
	
	@Test
	public void useNewWindow() {
		WebDriver	driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB); 
		newTab.get("https://google.com"); //control switich to new window 
	}
	
	@Test
	public void useRobat() throws AWTException {
		WebDriver	driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		
	}		
}