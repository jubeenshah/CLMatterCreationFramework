package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexisnexis.cl.q7.base.Base;

public class UserPage extends Base{

	@FindBy(xpath="//a[@id='btnLogin']/img")
	WebElement loginBtn;
	
	public UserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUserpageTitle() {
		return driver.getTitle();
	}
	
	public HomeUserPage verifyLoginBtnLink() {
		loginBtn.click();
		return new HomeUserPage();
	}
	
	
}
