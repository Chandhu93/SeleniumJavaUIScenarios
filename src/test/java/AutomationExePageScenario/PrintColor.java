package AutomationExePageScenario;

import org.openqa.selenium.support.Color;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PrintColor {

	@Test
	public void getColor() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement ele= driver.findElement(By.xpath("//h2[.='Scrolling DropDown']"));
		act.moveToElement(ele).perform();
		WebElement shape= driver.findElement(By.xpath("//h2[.='SVG Elements']/parent::div/descendant::div[@class='svg-container']/*[name()='svg']/*[name()='circle']"));
		String fontFamily =shape.getCssValue("");
		String clr =shape.getCssValue("color");
		String clrName =Color.fromString(clr).asHex();
		System.out.println(clrName);
		System.out.println(fontFamily);
		driver.quit();
	}
}
