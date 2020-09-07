package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexisnexis.cl.q7.base.Base;

public class OverviewMatterPage extends Base{
	
	@FindBy(xpath="//div[@id='matterTitle']")
	WebElement matterHeading;
	
	public OverviewMatterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyMatterName() {
		return matterHeading.isDisplayed();
		
	}

}
