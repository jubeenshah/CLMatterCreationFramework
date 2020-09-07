package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexisnexis.cl.q7.base.Base;

public class OfficePage extends Base {

	@FindBy(linkText="65010952")
	WebElement userId;
	
	public OfficePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyOfficeTitle() {
		return driver.getTitle();
	}
	
	public UserPage verifyUserIdLink() {
		userId.click();
		return new UserPage();
	}
	
	
}
