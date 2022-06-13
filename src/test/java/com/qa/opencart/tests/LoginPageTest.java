package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constants;
	
public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actTitle=loginPage.getLoginPageTitle();
		System.out.println("Login page titlr is"+actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void loginPageURLTest() {
		
		String actURL=loginPage.getLoginPageUrl();
      System.out.println("login page url"+actURL); 
		Assert.assertTrue(actURL.contains(Constants.LOGIN_PAGE_URL_FRACTION));

	
	}
	
	@Test
	public void isForgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist(), "isForgotPwdLink is exist");
	}
	
	@Test
	public void isregisterLinkExistTest() {
		Assert.assertTrue(loginPage.isregisterLinkExist());
	}
	
	@Test
	public void logintest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));		
	}
}
