package automtion.Scenario2;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class FlipkartTshitToCart {
	
	@Test
	public void cart() throws InterruptedException {
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(8));
		Actions a = new Actions(driver);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("Iphone", Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Men']")).click();
		driver.findElement(By.xpath("//a[text()='T-Shirts']")).click();
		WebElement e3 = driver.findElement(By.xpath("//div[text()='Brand']"));
		a.scrollToElement(e3).perform();
		e3.click();
		driver.findElement(By.xpath("//div[text()='PUMA']")).click();
		Thread.sleep(6000);
		j.executeScript("window.scrollTo(0, 4000);");
		
		WebElement e2 = driver.findElement(By.xpath("//a[text()='2']"));
		a.scrollToElement(e2).perform();
		e2.click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='_1sdMkc LFEi7Z']")).click();
		
		String parent= driver.getWindowHandle();
		Set<String> alWind = driver.getWindowHandles();
		for(String w: alWind) {
			if(w != parent) {
				driver.switchTo().window(w);
			}
		}
		Thread.sleep(6000);
		WebElement e4 = driver.findElement(By.xpath("//div[text()='You might be interested in']"));
		a.scrollToElement(e4).perform();
		WebElement e1 = driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']"));
		e1.click();
		WebElement e5 = driver.findElement(By.xpath("//button[text()='+']"));
		wait.until(ExpectedConditions.elementToBeClickable(e5));
		e5.click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//div[@class='cjMG1q']")).click();
		
		String price= driver.findElement(By.xpath("//span[@class='LAlF6k re6bBo']")).getText();
		System.out.println(price);
		String s = price.replaceAll("[^0-9]","");
		int p= Integer.parseInt(s);
		System.out.println(p);
		
		String tprice= driver.findElement(By.xpath("//div[@class='WH+Ng1']//span")).getText();
		System.out.println(tprice);
		String s1 = price.replaceAll("[^0-9]","");
		int p1= Integer.parseInt(s1);
		System.out.println(p1);
		assertEquals(p, p1);
		System.out.println("Validation done");
		driver.quit();
	}

}

















