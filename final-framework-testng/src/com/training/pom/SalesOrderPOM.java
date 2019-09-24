package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPOM {
	//private WebDriver driver; 
	public SalesOrderPOM(WebDriver driver) {
	  // this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//*[@id=\"menu-sale\"]")
	private WebElement MenuSales;
	
	@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[1]/a")
	private WebElement SalesOrders;
	
	@FindBy(id="input-order-id")
	public WebElement orderId; 
	
	@FindBy(id="button-filter")
	private WebElement filter; 
	
	@FindBy(id="input-customer")
	private WebElement customer;
	
	public void clickSalesMenu()
	{
		this.MenuSales.click();
	}
	
	public void clickSalesOrders()
	{
		this.SalesOrders.click();
	}
	
	public void sendorderId(String orderId) {
		this.orderId.clear();
		this.orderId.sendKeys(orderId);
	}
	
	public void clickFilter()
	{
		this.filter.click();
	}
	
	public void sendCustomer(String customer) {
		this.customer.clear();
		this.customer.sendKeys(customer);
	}
	
	
}


