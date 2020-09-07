package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexisnexis.cl.q7.base.Base;

public class HomePage extends Base{

	@FindBy(linkText="Corporate Customer Search")
	WebElement corporateSearch;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public CorporateCustomer validateSearchCorporateLink() {
		corporateSearch.click();
		return new CorporateCustomer();
	}
	
}
