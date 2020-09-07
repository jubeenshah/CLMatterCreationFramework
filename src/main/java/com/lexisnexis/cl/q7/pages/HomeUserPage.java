package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexisnexis.cl.q7.base.Base;

public class HomeUserPage extends Base{

	@FindBy(xpath="//a[@id='navbar-menuitem-Matters']")
	WebElement matterLink;
	
	public HomeUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyhomeUserPageTitle() {
		return driver.getTitle();
	}
	
	public MatterListPage verifyMatterLink() {
		matterLink.click();
		return new MatterListPage();
	}
}
