package QspPratice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllAutoSuggestions {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.zetexa.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Aust");
		List<WebElement> allsug = driver.findElements(By.xpath("//div[@role='listbox']"));
		int count= allsug.size();
		System.out.println(count);
		for (int i=0; i<count; i++) {
			String text= allsug.get(i).getText();
			System.out.println(text);
		}
		
	}
}
