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

public class CorporateCustomerTest extends Base{

	LoginPage loginPage;
	HomePage homePage;
	CorporateCustomer corpCustomer;
	CustomerListPage customerList;
	
	public CorporateCustomerTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		corpCustomer = new CorporateCustomer();
		customerList = new CustomerListPage();
		loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
		homePage.validateSearchCorporateLink();
	}
	
	@Test(priority=1)
	public void validateCorporateCustomerTitleTest() {
		String custSearchTitle= corpCustomer.validateCorporateCustomerTitle();
		Assert.assertEquals(custSearchTitle, "CounselLink - Corporate Customer Search");
	}
	
	@Test(priority=2)
	public void validateEnterClientTest() {
		customerList = corpCustomer.validateEnterClient();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		
	}
	
	
	
	
}
