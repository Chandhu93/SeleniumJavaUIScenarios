package RahulShettyAcademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.Assert;

public class PraticeTest {

	@Test
	public void displayTheElementTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		WebElement ele =  driver.findElement(By.id("show-textbox"));
		Actions act = new Actions(driver);
		act.scrollToElement(ele).perform();
		ele.click();
		WebElement textfield = driver.findElement(By.id("displayed-text"));
		if (textfield.isDisplayed()) {
			textfield.sendKeys("Hi");
		}
		driver.quit();
	}

	@Test
	public void selectSuggessionCountry() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.findElement(By.xpath("//fieldset/input[@id='autocomplete']")).sendKeys("India");
		driver.findElement(By.xpath("//ul/li/div[.='India']")).click();
		driver.quit();
	}
	
	@Test
	public void selectMultipleOptions() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		List<WebElement> options =  driver.findElements(By.xpath("//div[@id='checkbox-example']/fieldset/label/input"));
		for(WebElement option: options) {
			String text =option.getAttribute("value");
			option.click();
			if(option.isSelected()) {
				System.out.println(text+" is selected");
			}
		}
		driver.quit();
	}

	@Test
	public void selectAllRadioAndVerifyTest() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		List<WebElement> radioButtons = driver.findElements(By.xpath("//div[@id='radio-btn-example']/fieldset/label/input"));
		for(WebElement ele : radioButtons ) {
			ele.click();
			Assert.assertTrue(ele.isSelected(), ele.getAttribute("value")+"==Pass==");
		}
		driver.quit();
	}

	@Test
	public void getTextFromValuesUsingSingleXpath() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		WebElement tableCount= driver.findElement(By.xpath("//div[@class='totalAmount']"));
		Actions act = new  Actions(driver);
		act.scrollToElement(tableCount).perform();
		//div[@class='tableFixHead']/table/tbody/tr/td[.='Alex'] | //div[@class='tableFixHead']/table/tbody/tr/td[.='Jack']
		List<WebElement> list =driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[.='Alex' or .='Jack']/parent::tr/td"));
		for(WebElement ele : list) {
			String text = ele.getText();
			System.out.println(text);
		}
		driver.quit();
	}
	
	

}





