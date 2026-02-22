package QspPratice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllSuggestion {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("nse");
		Thread.sleep(3000);
		
List<WebElement> allSug = driver.findElements(By.xpath("//span[contains(text(),'java')]"));
		int count= allSug.size();
		System.out.println(count);
		for (int i=0; i<count; i++) {
			String text= allSug.get(i).getText();
			System.out.println(text);
		}
	}

}
