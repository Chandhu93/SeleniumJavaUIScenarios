package Amazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetFirstFiveProductOfAmazon {
	
	@Test
	public void getProductsTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("i Phone", Keys.ENTER);
		List<WebElement> list =driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
		
		for(int i=0; i<5; i++) {
			WebElement product = list.get(i);
			// "." (dot) --> search from inside that tag not entire DOM page
			String mobile = product.findElement(By.xpath(".//h2/span")).getText(); 
			String price = "";
			
			try {
			 price	 = product.findElement(By.xpath(".//span[@class='a-price-whole']")).getText();
			} catch (Exception e) {
				price = "Price Not Available";
			}
			System.out.println(mobile+ " --> "+ price);
		}
		driver.quit();
	}
	

}
