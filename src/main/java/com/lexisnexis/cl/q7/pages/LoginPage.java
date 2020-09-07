package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexisnexis.cl.q7.base.Base;

public class LoginPage extends Base{
	
	/*********OR*****************/
	
	
	@FindBy(name="username")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="btnSignIn")
	WebElement signIn;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement logo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
		
	}
	
	public HomePage validatelogin(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signIn.click();
		return new HomePage();
	}
	
	
	
	
	
	
	
	
}
