package SeleniumTrickyChallenges;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TrickyAutomationTable1 {
	@Test
	public void thirdTableHeader() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("file:///C:/Users/Dell/Desktop/automation_table_challenge.html");
		Actions act= new Actions(driver);
		WebElement table3= driver.findElement(By.xpath("//strong[.='Ledger 3']"));
		act.scrollToElement(table3).perform();
		List<WebElement> list = driver.findElements(By.xpath("//strong[.='Ledger 3']/ancestor::div[@class='table-title']/following-sibling::div[@class='data-table']/descendant::th"));
		for(WebElement ele: list) {
			System.out.println(ele.getText());
		}
		driver.quit();
	}
	
	@Test
	public void table7ClickAction() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("file:///C:/Users/Dell/Desktop/automation_table_challenge.html");
		Actions act= new Actions(driver);
		WebElement table7= driver.findElement(By.xpath("//strong[.='Ledger 7']"));
		act.scrollToElement(table7).perform();
		List<WebElement> list = driver.findElements(By.xpath("//strong[.='Ledger 7']/ancestor::div[@class='table-title']/following-sibling::div[@class='data-table']/table/tbody/tr/td/span[.='Pending']/parent::td/following-sibling::td/input"));
		for(WebElement ele: list) {
			ele.click();
		}
	}
	
	@Test
	public void table4PrintVisible() {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("file:///C:/Users/Dell/Desktop/automation_table_challenge.html");
		Actions act= new Actions(driver);
		WebElement table4= driver.findElement(By.xpath("//strong[.='Ledger 4']"));
		act.scrollToElement(table4);
		List<WebElement> list= driver.findElements(By.xpath("//strong[.='Ledger 4']/ancestor::div[@class='table-title']/following-sibling::div[@class='data-table']/div/table/tbody/tr"));
		int count=0;
		for(WebElement ele : list) {
			if(ele.isDisplayed()) count++;
		}
		System.out.println(count);
	}
	
	
	@Test
	public void QAdepertantment() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("file:///C:/Users/Dell/Desktop/automation_table_challenge.html");
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='card']/div[@class='data-table']/table/tbody/tr/td[contains(text(),'QA')]/parent::tr/descendant::td[@data-amt>5000]/parent::tr/descendant::td[position()=2]"));
		List<WebElement> emailId= driver.findElements(By.xpath("//div[@class='card']/div[@class='data-table']/table/tbody/tr/td[contains(text(),'QA')]/parent::tr/descendant::td[@data-amt>5000]/parent::tr/descendant::td[position()=6]"));
		for(int i=0; i<=names.size()-1; i++) {
			Thread.sleep(2000);
			String name= names.get(i).getText();
			String eId= emailId.get(i).getText();
			System.out.println(i+1+")"+name+" -- "+eId);
		}
	}
		
	
}
