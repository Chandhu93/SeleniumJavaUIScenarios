package automtion.Scenario2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Josalukkas {
	@Test
	public void make() throws InterruptedException {
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.manage().window().maximize();
		driver.get("https://www.josalukkaseasybuy.com/");
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		driver.findElement(By.xpath("//span[@class='icon-facebook gl-m-auto gl-fs-30 gl-xs-fs-20']")).click();
		driver.findElement(By.xpath("//span[@class='icon-twitter gl-m-auto gl-fs-30 gl-xs-fs-20']")).click();
		driver.findElement(By.xpath("//span[@class='icon-instagram gl-m-auto gl-fs-30 gl-xs-fs-20']")).click();
		
		Thread.sleep(5000);
		String parent = driver.getWindowHandle();
		Set<String> alWid = driver.getWindowHandles();
		for(String w :alWid) {
			driver.switchTo().window(w);
			String actUrl = driver.getCurrentUrl();
			if (!w.equals(parent)) {
				if(actUrl.contains("facebook")) {
					System.out.println("Facebook opened success ==> "+actUrl);
				} else if(actUrl.contains("instagram")) {
					System.out.println("Instagram opened success ==> "+actUrl);
				} else {
					System.out.println("X opened success ==>  "+actUrl);
				}
			}
		}
		
		driver.quit();
	}
}


















