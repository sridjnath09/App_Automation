package com.P1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class TC02_Read_Computer_Test {

	File file= new File("D:\\chromedriver.exe");
	public WebDriver driver ; 

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
	public void readComputer() throws ParseException {

		//values from list
		String listedComputerName=driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]")).getText();
		String listedIntroducedDate=driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[2]")).getText();
		String listedDiscontinuedDate=driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[3]")).getText();
		String listedCompany=driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[4]")).getText();


		
		Date_Convert dConvert=new Date_Convert();



		driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a")).click();

		//values from edit page 
		String computerName=driver.findElement(By.xpath("//*[@id=\"name\"]")).getAttribute("value");
		String introducedDate=driver.findElement(By.xpath("//*[@id=\"introduced\"]")).getAttribute("value");
		String discontinuedDate=driver.findElement(By.xpath("//*[@id=\"discontinued\"]")).getAttribute("value");
		Select dropdown= new Select(driver.findElement(By.id("company")));
		WebElement option = dropdown.getFirstSelectedOption();
		String selectedCompany = option.getText();


		Assert.assertEquals(listedComputerName.equals(computerName), true);
		
		if(!listedIntroducedDate.equals("-"))	{
			String convertListedIntroducedDate=dConvert.dateConvert(listedIntroducedDate);
			Assert.assertEquals(convertListedIntroducedDate.equals(introducedDate), true);
		}
		if(!listedDiscontinuedDate.equals("-")) {
			String convertListedDiscontinueDate=dConvert.dateConvert(listedDiscontinuedDate);
			Assert.assertEquals(convertListedDiscontinueDate.equals(discontinuedDate), true);
		}

		if(!listedCompany.equals("-"))
			Assert.assertEquals(listedCompany.equals(selectedCompany), true);

}


	@AfterMethod
	public void afterTest() {
		driver.close();
	}

}
