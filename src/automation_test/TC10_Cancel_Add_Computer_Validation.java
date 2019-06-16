package automation_test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC10_Cancel_Add_Computer_Validation {
	File file= new File("D:\\chromedriver.exe");
	public WebDriver driver ; 
	public  String computerName="Deep1";
	public  String introducedDate="2019-06-16";
	public String baseUrl;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
	    driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl="http://computer-database.herokuapp.com/computers";
		driver.get(baseUrl);
	}

	@Test
	public void cancelAddComputer() {
		driver.findElement(By.xpath("//*[@id=\"add\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(computerName);
		driver.findElement(By.xpath("//*[@id=\"introduced\"]")).sendKeys(introducedDate);

		Select dropdown= new Select(driver.findElement(By.id("company")));

		dropdown.selectByValue("1");
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/a")).click();

		String currentUrl= driver.getCurrentUrl();
		
		Assert.assertEquals(currentUrl.equals(baseUrl), true);
		
	}
	

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
