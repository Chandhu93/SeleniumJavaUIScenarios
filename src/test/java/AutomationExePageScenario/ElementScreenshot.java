	package AutomationExePageScenario;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ElementScreenshot {
	@Test
	public void elementScreenshot() throws IOException {
		
		String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy_HH-mm"));
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement ele= driver.findElement(By.xpath("//h2[.='Scrolling DropDown']"));
		act.moveToElement(ele).perform();
		WebElement shape= driver.findElement(By.xpath("//h2[.='SVG Elements']/parent::div/descendant::div[@class='svg-container']/*[name()='svg']/*[name()='circle']"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		File src= shape.getScreenshotAs(OutputType.FILE);
		File dest= new File("./screenShot/shape_"+date+".png");
		FileUtils.copyFile(src, dest);
	}

}
