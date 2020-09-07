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
import com.lexisnexis.cl.q7.pages.MatterListPage;
import com.lexisnexis.cl.q7.pages.OfficePage;
import com.lexisnexis.cl.q7.pages.UserPage;

public class HomeUserPageTest extends Base{

	LoginPage loginPage;
	HomePage homePage;
	CorporateCustomer corpCustomer;
	CustomerListPage customerList;
	OfficePage corpOfficePage;
	UserPage individualPage;
	HomeUserPage homeUser;
	MatterListPage matterList;
	
	public HomeUserPageTest() {
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
		matterList =  new MatterListPage();
		loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
		homePage.validateSearchCorporateLink();
		corpCustomer.validateEnterClient();
		customerList.verifyOfficeLink();
		corpOfficePage.verifyUserIdLink();
		individualPage.verifyLoginBtnLink();
		
	}
	
	@Test(priority=1)
	public void verifyhomeUserPageTitleTest() {
		String userTitle = homeUser.verifyhomeUserPageTitle();
		Assert.assertEquals(userTitle, "CounselLink");
	}
	
	@Test(priority=2)
	public void verifyMatterLink() {
		matterList = homeUser.verifyMatterLink();
	}
	
	@AfterMethod
	public void tesrDown() {
		driver.close();
	}
	
	
	
	
}
