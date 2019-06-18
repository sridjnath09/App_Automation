package com.P1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TC05_Delete_Computer_Test {

	File file= new File("D:\\chromedriver.exe");
	public WebDriver driver ; 
	public  String computerName="update1";
	

	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
	    driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String baseUrl="http://computer-database.herokuapp.com/computers";
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@Test
	public void deleteComputer() {
		driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"main\"]/form[2]/input")).click();
		
		String confirmCreation= driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]")).getText();
		Assert.assertEquals(confirmCreation.equals("Done! Computer has been deleted"),true);
		
	}
	

	@AfterMethod
	public void afterTest() {
		driver.close();
	}

}
