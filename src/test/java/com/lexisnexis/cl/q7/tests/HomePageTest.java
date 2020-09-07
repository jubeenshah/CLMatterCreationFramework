package com.lexisnexis.cl.q7.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lexisnexis.cl.q7.base.Base;
import com.lexisnexis.cl.q7.pages.CorporateCustomer;
import com.lexisnexis.cl.q7.pages.HomePage;
import com.lexisnexis.cl.q7.pages.LoginPage;

public class HomePageTest extends Base{
	
	HomePage homePage;
	CorporateCustomer corpCustomer;
	LoginPage loginPage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		corpCustomer = new CorporateCustomer();
		loginPage = new LoginPage();
		loginPage.validatelogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomePageTitleTest() {
		String homePageTitle= homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "CounselLink");
	}
	
	@Test(priority=2)
	public void validateCorporateSearchLinkTest() {
		corpCustomer = homePage.validateSearchCorporateLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
