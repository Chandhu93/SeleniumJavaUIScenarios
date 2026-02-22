package Amazon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FlixBusPriceSorting {
	
	@Test
	public void test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flixbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		ArrayList<Double> priceSet = new ArrayList<Double>();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		SearchContext host = driver.findElement(By.xpath("//div[@id='usercentrics-root']")).getShadowRoot();		
		host.findElement(By.cssSelector("button[data-testid='uc-deny-all-button']")).click();
		
		driver.findElement(By.xpath("//input[@id='searchInput-from']")).click();
		driver.findElement(By.xpath("//div[@class='YKJ72']//div[.='Bengaluru']")).click();
		
		driver.findElement(By.xpath("//input[@id='searchInput-to']")).click();
		driver.findElement(By.xpath("//div[@class='YKJ72']//div[.='Hyderabad']")).click();
		driver.findElement(By.xpath("//button[contains(@aria-label,'Select next day')]")).click();
		driver.findElement(By.xpath("//div[@class='aDOq1']/button")).click();
		
		Thread.sleep(1500);
		List<WebElement> priceList =driver.findElements(By.xpath("//ul[@data-e2e='search-result-list']/descendant::span[@class='SearchResult__price___QpySa' and @aria-hidden='true']"));
		
		System.out.println(priceList.size());
		
		for(WebElement ele : priceList) {
			String text  = ele.getText();
			
			double prAt = Double.parseDouble(
				    text.replaceAll("[^0-9.]", "")
				);
			priceSet.add(prAt);
		}
		Collections.sort(priceSet);
		System.out.println(priceSet);
		Thread.sleep(6000);
		driver.quit();
	}
}
