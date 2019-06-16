package automation_test;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.asserts.*;

public class TC02_Read_Computer_Test {

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
	public void readComputer() {
	
		driver.findElement(By.xpath("//*[@id=\"main\"]/table/tbody/tr[1]/td[1]/a")).click();
		String computerName=driver.findElement(By.xpath("//*[@id=\"name\"]")).getAttribute("value");
		System.out.println("computername ::"+computerName);
	}
	

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
