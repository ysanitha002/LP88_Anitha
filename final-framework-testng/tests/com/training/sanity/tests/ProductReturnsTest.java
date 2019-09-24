package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ProductReturnsPOM;
import com.training.pom.SalesOrderPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductReturnsTest {
	
	
	WebDriver driver;
	private ProductReturnsPOM returnsPOM;
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
	public void validProductReturnsTest() throws InterruptedException {	
		
		returnsPOM=new ProductReturnsPOM(driver);
		returnsPOM.clickSalesMenu();
		returnsPOM.clickSalesReturns();
	    returnsPOM.sendreturnId("150");	
	    returnsPOM.clickFilter();
				
		Thread.sleep(1000);
		screenShot.captureScreenShot("ProductReturnID");
		
		returnsPOM.returnId.clear();
		returnsPOM.sendCustomer("manzoor");
		returnsPOM.clickFilter();
		Thread.sleep(1000);
		screenShot.captureScreenShot("ProductCustomer");	
	}

}
