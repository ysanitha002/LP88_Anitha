package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteOrderPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteOrderTest {
	
	WebDriver driver;
	private DeleteOrderPOM deletePOM;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);	
		
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	} 
	
	@Test (priority=1)
	public void validLoginTest() throws Exception {
		
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		loginPOM = new LoginPOM(driver);
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("AdminLogin1");
		Thread.sleep(1000);
	}
	
	@Test (priority=2)
	public void validDeleteOrderTest() throws InterruptedException {	
		
		deletePOM=new DeleteOrderPOM(driver);
		deletePOM.clickSalesMenu();
		deletePOM.clickSalesOrders();
		deletePOM.sendorderId("275");
		deletePOM.clickFilter();
		
		Thread.sleep(1000);
		screenShot.captureScreenShot("DeleteSearchOrderID");
		
		deletePOM.selectcheckboxDelete();
		deletePOM.clickDelete();
		
		//JavascriptExecutor js= (JavascriptExecutor)driver;
		Alert alert = driver.switchTo().alert();
		String alertmsg=alert.getText();
		System.out.println(alertmsg);
		alert.accept();	
		
		String actual = deletePOM.getalertsuccessmsg();
		String expected = "Success: You have modified orders!";
		
		Assert.assertEquals(actual, expected);
		
		/*if (actual.contains("Success"))
			     System.out.println("Item has been successfully deleted ");
		else
			System.out.println("Item is not deleted properly"); */
		
		screenShot.captureScreenShot("DeleteSuccessOrderID");
				
	}

}
