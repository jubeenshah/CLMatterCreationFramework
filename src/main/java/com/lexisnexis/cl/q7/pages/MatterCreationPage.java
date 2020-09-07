package com.lexisnexis.cl.q7.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lexisnexis.cl.q7.base.Base;

public class MatterCreationPage extends Base{

	
	@FindBy(name="title")
	WebElement matterTitle;
	
	@FindBy(name="contactOfficeId")
	WebElement contactOffice;
	
	@FindBy(name="matterContactId")
	WebElement matterContact;
	
	@FindBy(name="invoiceContactId")
	WebElement invoiceContact;
	
	@FindBy(xpath="//input[@id='btnSave']")
	WebElement saveBtnMatter;
	
	@FindBy(xpath="//input[@id='btnCancel']")
	WebElement cancelBtnmatter;
	
	@FindBy(xpath="//input[@id='lookUpImg']")
	WebElement matterTypeList;
	
	@FindBy(linkText="Compliance")
	WebElement matterType;
	
	public MatterCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCreateMatterTitle() {
		return driver.getTitle();
	}

	public OverviewMatterPage verifyCreationOfMatter() {
		matterTitle.sendKeys("Second matter");
		selectByValue(contactOffice,prop.getProperty("contactOffice"));
		selectByValue(matterContact,prop.getProperty("matterContact"));
		selectByValue(invoiceContact,prop.getProperty("invoiceContact"));
		matterTypeList.click();
		matterType.click();
		saveBtnMatter.click();
		return new OverviewMatterPage();
	}
	
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		
		select.selectByVisibleText(value);	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
