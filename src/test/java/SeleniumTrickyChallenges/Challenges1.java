package SeleniumTrickyChallenges;

import java.time.Duration;

import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Challenges1 {
	
	@Test
	public void addAndRemove() {
		WebDriver	driver= new ChromeDriver();
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='add-item']")).click();
		driver.findElement(By.xpath("//span/button[@class='complete']")).click();
		driver.findElement(By.xpath("//button[@id='remove-item']")).click();
		driver.quit();
	}
	
	@Test
	public void add10() throws InterruptedException {
		WebDriver	driver= new ChromeDriver();
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='populate-10']")).click();
		List<WebElement> buttons = driver.findElements(By.xpath("//button[@class='complete']"));
		for(WebElement btn: buttons) {
			btn.click();
			Thread.sleep(400);
		}
		driver.findElement(By.xpath("//button[@id='remove-item']")).click();
		driver.quit();
	}
	
	@Test
	public void shadowRoot() {
		WebDriver	driver= new ChromeDriver();
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		 SearchContext shadowHost = driver.findElement(By.id("shadow-host")).getShadowRoot();
		 shadowHost.findElement(By.cssSelector("input[placeholder='type here']")).sendKeys("Hi");
		 shadowHost.findElement(By.cssSelector("button[id='shadow-btn']")).click();
		// driver.quit();
	}	
	
	@Test
	public void nestedIFrame() {
		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		
		driver.quit();
	}
		
	@Test
	public void ajaxApp() throws InterruptedException {
		WebDriver	driver= new ChromeDriver();
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		boolean found = false;
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@id='start-ajax']")).click();
		Thread.sleep(Duration.ofSeconds(10));
		List<WebElement> lst = driver.findElements(By.xpath("//div[@id='ajax-list']"));
		for(int i=0; i<lst.size(); i++) {
			String exp = "special-keyword";
			String ele = lst.get(i).getText().trim();
			System.out.println(ele);
			if(ele.contains(exp)) System.out.println("No special keyword");
		}
		driver.quit();
	}
	
	@Test
	public void uploadFile() throws InterruptedException {
		WebDriver	driver= new ChromeDriver();
		driver.get("file:///C:/Users/Dell/Desktop/selenium_tricky_challenges_html_css_simulation.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='real-file']")).sendKeys("E:\\Tek_Pyramid\\Extent_Report");
		String actFile= driver.findElement(By.xpath("//div[@id='upload-result']")).getText();
		String expFile= "Extent_Report";
		if(actFile.equals(expFile)) System.out.println(expFile+" File is uploaded");
		else System.out.println(" File is NOT Uploaded");
		Thread.sleep(8000);
		driver.quit();
	}
	
}












