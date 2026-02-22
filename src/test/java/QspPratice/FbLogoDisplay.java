package QspPratice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FbLogoDisplay {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		boolean logo = driver.findElement(By.xpath("//img[@alt='Facebook']")).isDisplayed();
		if(logo==true)
			System.out.print("Logo is displayed and Pass");
		else
			System.out.println("Logo is not displayed and Fail");
		driver.close();
	}

}
