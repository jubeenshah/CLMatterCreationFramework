package com.lexisnexis.cl.q7.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lexisnexis.cl.q7.base.Base;
import com.lexisnexis.cl.q7.pages.CorporateCustomer;
import com.lexisnexis.cl.q7.pages.CustomerListPage;
import com.lexisnexis.cl.q7.pages.HomePage;
import com.lexisnexis.cl.q7.pages.LoginPage;
import com.lexisnexis.cl.q7.pages.OfficePage;



public class CustomerListPageTest extends Base{
	
	LoginPage loginPage;
	HomePage homePage;
	CorporateCustomer corpCustomer;
	CustomerListPage customerList;
	OfficePage corpOfficePage;
	
	public CustomerListPageTest() {
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
		loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
		homePage.validateSearchCorporateLink();
		corpCustomer.validateEnterClient();
	}
	
	@Test(priority=1)
	public void verifyCustomerListPageTitleTest() {
		String custListTitle = customerList.verifyCustomerListPageTitle();
		Assert.assertEquals(custListTitle, "CounselLink - Corporate Customer Administration: "+prop.getProperty("clientName"));
	}
	
	@Test(priority=2)
	public void verifyOfficeLinkTest() {
		corpOfficePage = customerList.verifyOfficeLink();
	} 
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}

