package AutomationExePageScenario;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestAutomationPractice {
	
	@Test
	public void testAuto() throws InterruptedException {
		String product="Soundbar";
		String price="";
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement e1 = driver.findElement(By.xpath("//h2[.='Dynamic Web Table']"));

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0, 2600)");
		
		for(int i=0; i<=4; i++) {
			try {
				WebElement pr= driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td[.='"+product+"']"));
				driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td[.='"+product+"']/following-sibling::td/input")).click();
				Thread.sleep(8000);
				price=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td[.='"+product+"']/following-sibling::td[1]")).getText();
				System.out.println(pr.getText()+": "+"pageNo-"+i);
				System.out.println(price);
			} catch (Exception e) {
				driver.findElement(By.xpath("//div[@class='table-container']/ul/li/a[.='" + (i + 1) + "']")).click();
			}
			driver.quit();
	}
	}
}
