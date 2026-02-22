package automation.Scenario1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WorldPopulation {
	@Test
	public void pop() {
		String country= "poland"; //use small character
		int totalPage= 24;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		driver.get("https://www.worldometers.info/world-population/");
		driver.findElement(By.linkText("Population by Country")).click();

		for(int i=1; i<= totalPage; i++) { 
			List<WebElement> ele = driver.findElements(By.xpath("//td[a[@data-country='"+country+"']]"));
			if(ele.size()>0) {
				String e1 = driver.findElement(By.xpath("//tr[@id='"+country+"']/td[position() = last() - 0]")).getText();	
				for(WebElement e : ele) {
					System.out.println(e.getText()+": "+"pageNo-"+i);
					System.out.println("World Share: "+e1);
				}
				break;
			} else {
				WebElement ele1 = driver.findElement(By.xpath("//button[text()='›']"));
				wait.until(ExpectedConditions.visibilityOf(ele1)).click();
			}
		}
		driver.quit();
	}
}














