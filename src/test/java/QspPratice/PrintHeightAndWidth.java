package QspPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintHeightAndWidth {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		WebElement login = driver.findElement(By.name("login"));
		int height= login.getSize().getHeight();
		int width = login.getSize().getWidth();
		System.out.println("Height "+ height);
		System.out.println("Width "+ width);
		driver.quit();
	}

}
