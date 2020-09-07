package com.lexisnexis.cl.q7.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lexisnexis.cl.q7.base.Base;
import com.lexisnexis.cl.q7.pages.CorporateCustomer;
import com.lexisnexis.cl.q7.pages.CustomerListPage;
import com.lexisnexis.cl.q7.pages.HomePage;
import com.lexisnexis.cl.q7.pages.HomeUserPage;
import com.lexisnexis.cl.q7.pages.LoginPage;
import com.lexisnexis.cl.q7.pages.OfficePage;
import com.lexisnexis.cl.q7.pages.UserPage;

public class UserPageTest extends Base{

	LoginPage loginPage;
	HomePage homePage;
	CorporateCustomer corpCustomer;
	CustomerListPage customerList;
	OfficePage corpOfficePage;
	UserPage individualPage;
	HomeUserPage homeUser;
	
	public UserPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		corpCustomer = new CorporateCustomer();
		customerList = new CustomerListPage();
		corpOfficePage = new OfficePage();
		individualPage = new UserPage();
		homeUser = new HomeUserPage();
		loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
		homePage.validateSearchCorporateLink();
		corpCustomer.validateEnterClient();
		customerList.verifyOfficeLink();
		corpOfficePage.verifyUserIdLink();
	}
	
	@Test(priority=1)
	public void verifyUserpageTitleTest() {
		String userTitle = individualPage.verifyUserpageTitle();
		Assert.assertEquals(userTitle, "CounselLink - Corporate Customer Administration: Individual Viewww","wrong title fetched");
	}
	
	@Test(priority=2)
	public void verifyLoginBtnLinkTest() {
		homeUser = individualPage.verifyLoginBtnLink();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
}
