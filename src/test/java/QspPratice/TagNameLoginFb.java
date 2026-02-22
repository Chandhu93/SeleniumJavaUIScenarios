package QspPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagNameLoginFb {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		String tagName = driver.findElement(By.id("loginbutton")).getTagName();
		System.out.println(tagName);
		driver.quit();
	}

}
