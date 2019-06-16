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

public class TC04_Search_Existing_Computer_Test {
	
	File file= new File("D:\\chromedriver.exe");
	public WebDriver driver ; 
	public  String computerName="update1";


	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String baseUrl="http://computer-database.herokuapp.com/computers";
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@Test
	public void updateComputer() {
		driver.findElement(By.id("searchbox")).clear();
		driver.findElement(By.id("searchbox")).sendKeys(computerName);
		driver.findElement(By.id("searchsubmit")).click();
		
		String listedComputer= driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr/td[1]/a")).getText();
		Assert.assertEquals(listedComputer.equals(computerName),true);
		
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
