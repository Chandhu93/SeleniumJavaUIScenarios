package Selenium_Miscellealous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HandlingCalanderInBookingSites {

	@Test
	public void goibboCalander() throws InterruptedException {

		String  date="Tue Sep 09 2025";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!RSA!108599293!6504095653!617695092667!e!go%20ib%20go!c!&gad_source=1&gad_campaignid=108599293&gbraid=0AAAAADrlxCdUSNS5eDzi-u1I_-xHcztRC&gclid=CjwKCAjwgb_CBhBMEiwA0p3oOB080L4jgI7SG0lMRKO7p81Kgx4ThoyPBJ4hqpOnt6c3lvWg59VkeBoCcbEQAvD_BwE");

		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='DayPicker']")));
		boolean b = false;
		for(; b==false; ) {
			try {
				Thread.sleep(9000);
				driver.findElement(By.xpath("//div[@aria-label='"+date+"']")).click();
				b=true;
				break;
			} catch (Exception e) {	
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
	}

	@Test
	public void makeMyTripCalander()  {

		String  date="Tue Sep 09 2025";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://www.makemytrip.com/");
		
		

	}

}






