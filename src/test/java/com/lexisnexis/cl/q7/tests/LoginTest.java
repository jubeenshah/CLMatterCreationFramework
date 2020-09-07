package com.lexisnexis.cl.q7.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lexisnexis.cl.q7.base.Base;
import com.lexisnexis.cl.q7.pages.HomePage;
import com.lexisnexis.cl.q7.pages.LoginPage;

public class LoginTest extends Base  {
	
	LoginPage loginPage;
	HomePage homepage;
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homepage = new HomePage();
		
		
	}
	
	@Test(priority=1)
	public void validateLoginTitleTest() {
		String loginTitle=loginPage.validateLoginTitle();
		Assert.assertEquals(loginTitle, "CounselLinkPage","page title wrong title");
	}
	
	@Test(priority=2)
	public void validateLogoTest() {
	Boolean flag =	loginPage.validateLogo();
	Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void validateLogin() {
		homepage =loginPage.validatelogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
