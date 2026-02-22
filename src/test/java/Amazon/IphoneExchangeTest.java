package Amazon;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IphoneExchangeTest {
	
	// Dynamic xpath for price of particular mobile iPhone, Samsung
	//div[@role ='listitem']/descendant::span[contains(text(), 'iPhone 17 Pro 256 GB') and contains(text(), 'Orange')]/ancestor::div[@data-cy='title-recipe']/following-sibling::div[@class='puisg-row puis-desktop-list-row']/descendant::span[@class='a-offscreen']

	@Test
	public void getOrangeIphoneFromList() {

		WebDriver driver =  new ChromeDriver();
		driver.get("https://www.amazon.in/ref=nav_logo");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		String colour= "Orange";

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("I phone", Keys.ENTER);

		List<WebElement> allPhone = driver.findElements(By.xpath("//a/h2/span[contains(text(), 'iPhone')]"));
		String parentWindow = driver.getWindowHandle();
		for(WebElement phone: allPhone) {
			String text = phone.getText();
			System.out.println(text);
			if(text.contains(colour)) {
				Assert.assertTrue(text.contains("Orange"), "Orange colour phone NOT found "+text);
				phone.click();
				break;
			}
		}

		Set<String> allWindow =  driver.getWindowHandles();
		for(String wind: allWindow) {
			if(!wind.equals(parentWindow)) {
				driver.switchTo().window(wind);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='gift-wrap']")).click();
		driver.findElement(By.xpath("//i[@class='a-icon a-accordion-radio a-icon-radio-inactive']")).click();
		driver.findElement(By.xpath("//span[@id='chooseButton']")).click();

		String mobile = "Samsung";
		String mobileType = "Galaxy S25 Ultra";
		
		WebElement mobileDD = driver.findElement(By.xpath("//div[@class='a-popover-wrapper']/descendant::div[@id='buyBackDropDowns1']/span/select"));
		Select sel = new Select(mobileDD);
		sel.selectByValue(mobile);

		WebElement modelDD =driver.findElement(By.xpath("//div[@id='buyBackDropDown2Button']/descendant::select[@name='"+mobile+"']"));
		Select s2 = new Select(modelDD);
		s2.selectByValue(mobileType);

		WebElement ram = driver.findElement(By.id("buyBackDropDown3Button"));
		if(ram.isDisplayed()) {
			WebElement modelsList = driver.findElement(By.xpath("//select[@id='"+mobile+mobileType+"']"));
			Select s3 = new Select(modelsList);
			s3.selectByValue("12GB | 1TB");
		}
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement noDamage = driver.findElement(By.xpath("//table/descendant::td[@id='noBodyDamageColumn']/descendant::i"));
//		js.executeScript("arguments[0].click();", noDamage);

		driver.findElement(By.xpath("//table/descendant::td[@id='noBodyDamageColumn']/descendant::i")).click();
		driver.findElement(By.xpath("//span[@id='value-commensurate-with-granularity-continue-button']")).click();
		String exchangeValue =driver.findElement(By.xpath("//div/descendant::span[@id='valueCommensurateDiscountPrice']")).getText();
		System.out.println("Excahnge Value --> "+exchangeValue);
		driver.quit();
	}

}
