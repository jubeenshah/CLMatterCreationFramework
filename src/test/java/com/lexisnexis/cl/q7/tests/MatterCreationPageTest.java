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
import com.lexisnexis.cl.q7.pages.MatterCreationPage;
import com.lexisnexis.cl.q7.pages.MatterListPage;
import com.lexisnexis.cl.q7.pages.OfficePage;
import com.lexisnexis.cl.q7.pages.OverviewMatterPage;
import com.lexisnexis.cl.q7.pages.UserPage;

public class MatterCreationPageTest extends Base {

	LoginPage loginPage;
	HomePage homePage;
	CorporateCustomer corpCustomer;
	CustomerListPage customerList;
	OfficePage corpOfficePage;
	UserPage individualPage;
	HomeUserPage homeUser;
	MatterListPage matterList;
	MatterCreationPage createMatter;
	OverviewMatterPage matterOverview;
	
	
	public MatterCreationPageTest() {
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
		createMatter = new MatterCreationPage();
		matterOverview = new OverviewMatterPage();
		
		loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
		homePage.validateSearchCorporateLink();
		corpCustomer.validateEnterClient();
		customerList.verifyOfficeLink();
		corpOfficePage.verifyUserIdLink();
		individualPage.verifyLoginBtnLink();
		homeUser.verifyMatterLink();
		matterList.verifyCreateMatterLink();
	}
	
	@Test(priority=1)
	public void verifyCreateMatterTitleTest() {
		String titleOfCreateMatter = createMatter.verifyCreateMatterTitle();
		Assert.assertEquals(titleOfCreateMatter, "CounselLink - Matt Create","something is missing");
	}
	
	@Test(priority=2)
	public void verifyCreationOfMatterTest() {
		matterOverview = createMatter.verifyCreationOfMatter();
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
