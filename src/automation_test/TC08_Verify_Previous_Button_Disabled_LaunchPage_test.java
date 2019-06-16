package automation_test;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC08_Verify_Previous_Button_Disabled_LaunchPage_test {
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
	public void verifyPreviousDisabled() {
		WebElement element=driver.findElement(By.xpath("//*[@id=\"pagination\"]/ul/li[1]"));
		String classes=element.getAttribute("class");
		boolean isDisabled= classes.contains("prev disabled");
		System.out.println("returnnn  "+classes);
		Assert.assertEquals(isDisabled,true);		
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
}
