package QspPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CopyPasteText {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opensourcebilling.org/en/users/sign_in");
		driver.findElement(By.id("email")).sendKeys(Keys.CONTROL+"ac");
		driver.findElement(By.id("password")).sendKeys(Keys.CONTROL+"av");
		driver.close();
	}

}
