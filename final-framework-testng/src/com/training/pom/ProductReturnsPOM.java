package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductReturnsPOM {
	
	public ProductReturnsPOM(WebDriver driver) {
	  	PageFactory.initElements(driver, this);
	} 
	
	@FindBy(xpath="//*[@id=\"menu-sale\"]")
	private WebElement menuSales;
	
	@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[3]/a")
	private WebElement salesReturns;
	
	@FindBy(id="input-return-id")
	public WebElement returnId; 
	
	@FindBy(id="button-filter")
	private WebElement filter; 
	
	@FindBy(id="input-customer")
	private WebElement customer;
	
	public void clickSalesMenu()
	{
		this.menuSales.click();
	}
	
	public void clickSalesReturns()
	{
		this.salesReturns.click();
	}
	
	public void sendreturnId(String returnId) {
		this.returnId.clear();
		this.returnId.sendKeys(returnId);
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
