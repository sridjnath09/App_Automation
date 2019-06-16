package automation_test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC09_Verify_Previous_Button_Enabled_NextPage_test {

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
	public void verifyPreviousEnabled() {
		driver.findElement(By.xpath("//*[@id=\"pagination\"]/ul/li[3]/a")).click();
		WebElement element=driver.findElement(By.xpath("//*[@id=\"pagination\"]/ul/li[1]/a"));
		boolean isEnabled= element.isEnabled();
		Assert.assertEquals(isEnabled,true);		
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
}
