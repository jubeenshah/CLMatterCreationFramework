package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexisnexis.cl.q7.base.Base;

public class CustomerListPage extends Base{

	@FindBy(linkText="65010949")
	WebElement officeLink;
	
	public CustomerListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCustomerListPageTitle() {
		return driver.getTitle();
	}
	
	public OfficePage verifyOfficeLink() {
		officeLink.click();
		return new OfficePage();
	}
	
	
}
