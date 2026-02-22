package AutomationExePageScenario;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PaginationWebTable {

	@Test
	public void table() {
		String prod = "Wireless Mouse 20";
		Boolean prodFound= false;
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 2700);");

		for(int i=1; i<=4; i++) {
			List<WebElement> lst =driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td[.='"+prod+"']"));
			if(lst.size()>0) {
				String price= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td[position()=3]")).getText();

				for(WebElement e : lst) {
					driver.findElement(By.xpath(
							"//table[@id='productTable']//td[text()='" + prod + "']/following-sibling::td//input[@type='checkbox']"
							)).click();
					System.out.println(e.getText()+": "+"pageNo-"+i);
					System.out.println(price);
					prodFound = true;
				}
				break;
			}
			else {
				driver.findElement(By.xpath("//div[@class='table-container']/ul/li/a[.='" + (i + 1) + "']")).click();
			}
		}
		if(prodFound== false)
			System.out.println("Product " + prod + " not found on any page.");			
		driver.quit();
	}

	//div[@class='svg-container']/child::*[name()='svg'][position()=3]

	@Test
	public void tableUsingTryCatch() {
		String prod = "Soundbar";
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 2700);");

		for(int i=0; i<=4; i++) {
			try {
				WebElement pr = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td[.='"+prod+"']"));
				String price= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td[position()=3]")).getText();

					driver.findElement(By.xpath(
							"//table[@id='productTable']//td[text()='" + prod + "']/following-sibling::td//input[@type='checkbox']"
							)).click();
					System.out.println(pr.getText()+": "+"pageNo-"+i);
					System.out.println(price);
			} catch (Exception e) {
				driver.findElement(By.xpath("//div[@class='table-container']/ul/li/a[.='" + (i + 1) + "']")).click();
			}
		}
		driver.quit();
	}

}


















