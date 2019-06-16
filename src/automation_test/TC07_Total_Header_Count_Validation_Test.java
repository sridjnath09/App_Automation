package automation_test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC07_Total_Header_Count_Validation_Test {
	File file= new File("D:\\chromedriver.exe");
	public WebDriver driver ; 



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
	public void countValidation() {
		String header=driver.findElement(By.xpath("//*[@id=\"main\"]/h1")).getText();
		String headerCount=StringUtils.split(header, " ")[0];
		
		String listCount=driver.findElement(By.xpath("//*[@id=\"pagination\"]/ul/li[2]/a")).getText();
		Assert.assertEquals(listCount.contains(headerCount),true);		
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
	
}
