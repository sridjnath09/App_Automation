package com.P1;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC03_Update_Information_Test {
	File file= new File("D:\\chromedriver.exe");
	public WebDriver driver ; 
	public  String computerName="update1";
	public  String introducedDate="2019-06-16"; 

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
	public void updateComputer() {
		driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(computerName);

		Select dropdown= new Select(driver.findElement(By.id("company")));
		dropdown.selectByValue("1");
		
		

		driver.findElement(By.xpath("//*[@id=\"main\"]/form[1]/div/input")).click();

		String confirmUpdate= driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]")).getText();
		Assert.assertEquals(confirmUpdate.equals("Done! Computer "+computerName+" has been updated"),true);
		
		
		

	}


	@AfterMethod
	public void afterTest() {
		driver.close();
	}
}
