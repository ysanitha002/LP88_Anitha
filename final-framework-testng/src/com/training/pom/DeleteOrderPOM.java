package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrderPOM {
	
	public DeleteOrderPOM(WebDriver driver) {
		  	PageFactory.initElements(driver, this);
		} 
		
		@FindBy(xpath="//*[@id=\"menu-sale\"]")
		private WebElement MenuSales;
		
		@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[1]/a")
		private WebElement SalesOrders;
		
		@FindBy(id="input-order-id")
		public WebElement orderId; 
		
		@FindBy(xpath="//input[@name='selected[]']")
		private WebElement checkboxDelete;
		
		@FindBy(id="button-delete")
		private WebElement delete;
		
		@FindBy(id="button-filter")
		private WebElement filter; 
		
		@FindBy(xpath="//*[@class='alert alert-success']")
		private WebElement alertsuccess;
		
		public String alertsuccessmsg;
		
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
		
		public void selectcheckboxDelete() {
			this.checkboxDelete.click();
			boolean checked = checkboxDelete.isSelected();
			if (checked==true)
				System.out.println("The Order Id is checked for deletion");
			else
				this.checkboxDelete.click();	
		}
		
		public void clickDelete() {
			this.delete.click();
		}
		
		public void clickFilter()
		{
			this.filter.click();
		}
		
		public String getalertsuccessmsg() {
			this.alertsuccessmsg = this.alertsuccess.getText();
			System.out.println("Alert Success Msg is : "+ alertsuccessmsg);
			return this.alertsuccessmsg;
		}
}
