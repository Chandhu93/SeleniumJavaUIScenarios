package QspPratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerfiyCurrentUrl {

	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.seleniumhq.org");
		String url= driver.getCurrentUrl();
		if(url.equals("https://www.selenium.dev/")) {
			System.out.println("URL is successfully navigation and Pass");
		}
		else
			System.out.println("URL is not successfully navigation and Fail");
		driver.quit();
	}
}
