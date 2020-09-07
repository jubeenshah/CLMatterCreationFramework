package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexisnexis.cl.q7.base.Base;

public class MatterListPage extends Base{
	
	@FindBy(id="page-heading")
	WebElement pageHeading;
	
	@FindBy(xpath="//a[@id='create-matter-button']/span")
	WebElement createMatterLink;
	
	
	public MatterListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageHeading() {
		return pageHeading.getText();
	}
	
	public MatterCreationPage verifyCreateMatterLink() {
		createMatterLink.click();
		return new MatterCreationPage();
	}

}
