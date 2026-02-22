package automation.Scenario1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WorldMeterToolTip {
	@Test
	public void world() {
		String catagory= "Food & Agriculture";
		String country="India";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		driver.get("https://www.worldometers.info/geography/countries-of-the-world/");
		
		driver.findElement(By.id("header-nav-more-trigger")).click();
		driver.findElement(By.xpath("//a[text()='"+catagory+"']")).click();
		driver.findElement(By.xpath("//a[text()='"+country+"']")).click();
		driver.findElement(By.xpath("//div[@id='country-undernourished-chart']")).click();
		
		Actions a = new Actions(driver);
//		WebElement chartPoint = driver.findElement(By.cssSelector("g.highcharts-series > path")); 
//
//		actions.moveToElement(chartPoint).perform();
//		
//		WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g.highcharts-tooltip")));
//		
//		String tooltipText = tooltip.getText();
//		System.out.println("Tooltip text: " + tooltipText);
		
		WebElement yr = driver.findElement(By.xpath("//*[contains(@class, 'highcharts-xaxis-labels')]/*[text()='2005']"));
		
		
		
		
		
		driver.quit();
	}
}












