package Amazon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.ExitCode;

public class PrintAirpodsTest {

	@Test
	public void printAirpodsSwitchCaseTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Airpods", Keys.ENTER);
		List<WebElement> list = driver.findElements(By.xpath("//div[@role='listitem']/descendant::h2/span"));

		int i=0;
		for (WebElement ele : list) {
			String text = ele.getText();
			String airpods = text.contains("AirPods") ? "found": "not found";  // use string
			i++; // position of product in the list
			switch (airpods) {
				case "found":
					Assert.assertTrue(true, "Product contains AirPods");
					System.out.println(i + ") " + text);
					break;
	
				case "not found":
					continue;			// skip the non airpods
			}
		}
		driver.quit();
	}

	// not best pratice to use in java, using null inside ternary operator
	/*
	 * @Test public void printAirpodsTest() { WebDriver driver = new ChromeDriver();
	 * driver.get("https://www.amazon.in/ref=nav_logo");
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));
	 * driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Airpods",
	 * Keys.ENTER); List<WebElement> list =
	 * driver.findElements(By.xpath("//div[@role='listitem']/descendant::h2/span"));
	 * 
	 * int i=0; for (WebElement ele : list) { String text = ele.getText(); //
	 * Conditional operator: Non-Airpods --> NullPointerException try { i++; // to
	 * get position of product in the list or web page
	 * Assert.assertTrue(text.contains("AirPods") ? true : null , "");
	 * System.out.println(i+") "+text); //i++ // just for numbering } catch
	 * (Exception e) { continue; } } driver.quit(); }
	 */
}
