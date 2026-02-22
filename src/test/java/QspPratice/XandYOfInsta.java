package QspPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XandYOfInsta {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/accounts/login/?hl=en");
		int x = driver.findElement(By.xpath("//button[@type='submit']")).getLocation().getX();
		int y = driver.findElement(By.xpath("//button[@type='submit']")).getLocation().getY();
		System.out.println(x);
		System.out.println(y);
		
	}

}
