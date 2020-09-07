package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexisnexis.cl.q7.base.Base;

public class CorporateCustomer extends Base {

	@FindBy(name="client_name")
	WebElement customerName;
	
	@FindBy(xpath="//[@name='cl_search']/a[2]/img")
	WebElement search;
	
	public CorporateCustomer(){
		PageFactory.initElements(driver,this);
	}
	
	public String validateCorporateCustomerTitle() {
		return driver.getTitle();
	}
	
	public CustomerListPage validateEnterClient(){
		customerName.sendKeys(prop.getProperty("clientName"));
		customerName.sendKeys(Keys.ENTER);
		return new CustomerListPage();
	}
	
	
	
	
	
	
}
