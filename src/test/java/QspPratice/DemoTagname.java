package QspPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTagname {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Dell/Desktop/Demo.html");
		WebElement e = driver.findElement(By.tagName("a"));
		Thread.sleep(2000);
		e.click();
		driver.navigate().back(); 
		Thread.sleep(2000);
		WebElement ele1=driver .findElement(By.id("d2"));
		ele1.click();
		driver.navigate().back();
		WebElement ele2=driver.findElement(By.name("n1"));
		ele2.click();
		driver.navigate().back();
		driver.findElement(By.className("c2")).click();
		
	}

}
