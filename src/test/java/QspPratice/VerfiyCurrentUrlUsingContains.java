package QspPratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerfiyCurrentUrlUsingContains {

	public static void main(String[] args) {
		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.gmail.com");
		String url= driver.getCurrentUrl();
		if(url.contains("google")) {
			System.out.println("URL is contain's and Pass");
		}
		else
			System.out.println("URL is not contian's navigation and Fail");
		driver.quit();
	}
}
