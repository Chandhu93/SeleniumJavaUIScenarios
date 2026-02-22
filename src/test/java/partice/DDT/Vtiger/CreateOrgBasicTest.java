package partice.DDT.Vtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgBasicTest {

	public static void main(String[] args) throws IOException {
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\Desktop\\data\\commanData.properties");
		Properties p = new Properties();
		p.load(fis);

		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");

		WebDriver driver =null;

		if(browser.equals("chrome"))
			driver= new ChromeDriver();
		else if(browser.equals("edge"))
			driver = new EdgeDriver();
		else if(browser.equals("firefox"))
			driver= new FirefoxDriver();
		else
			driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		FileInputStream fis1 = new FileInputStream("C:\\Users\\Dell\\Desktop\\data\\testScriptDataVTiger.xlsx");

		Workbook wb = WorkbookFactory.create(fis1);
		String text = wb.getSheet("org").getRow(1).getCell(2).getStringCellValue()+ranNum;
		wb.close();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img [@title='Create Organization...']")).click();
		driver.findElement(By.className("detailedViewTextBox")).sendKeys(text + Keys.ENTER);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img [@src='themes/softed/images/user.PNG']"))).click();
		a.perform();
		
		driver.findElement(By.xpath("//a [text()='Sign Out']")).click();
		driver.quit();
		
	}
}
