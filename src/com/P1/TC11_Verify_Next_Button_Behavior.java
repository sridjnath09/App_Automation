package com.P1;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC11_Verify_Next_Button_Behavior {

	File file= new File("D:\\chromedriver.exe");
	public WebDriver driver ; 
	public String baseUrl="http://computer-database.herokuapp.com/computers";
	public String nextPageUrl="http://computer-database.herokuapp.com/computers?p=1";


	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@Test
	public void verifyNextButton() {
		driver.findElement(By.xpath("//*[@id=\"pagination\"]/ul/li[3]/a")).click();
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentUrl.equals(nextPageUrl), true);
	}


	@AfterMethod
	public void afterTest() {
		driver.close();
	}
}
