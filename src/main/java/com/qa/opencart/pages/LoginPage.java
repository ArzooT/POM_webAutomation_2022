package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	// 1. private By Locators: OR
		private By emailId = By.id("input-email");
		private By password = By.id("input-password");
		private By loginBtn = By.xpath("//input[@value='Login']");
		private By forgotPwdLink = By.linkText("Forgotten Password");
		private By registerLink = By.linkText("Register");
		private By logoutSuccessMesg = By.cssSelector("div#common-success h1");

		// 2. page const....
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			eleUtil = new ElementUtil(this.driver);
		}

		// 3. page actions:
		public String getLoginPageTitle() {
			return eleUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
		}

		public String getLoginPageUrl() {
			return eleUtil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION, Constants.DEFAULT_TIME_OUT);
			
		}
		
		public AccountsPage doLogin(String un,String pwd) {
			System.out.println("login creds are: " + un + " : " + pwd);
           eleUtil.waitForElementVisible(emailId, Constants.DEFAULT_TIME_OUT).sendKeys(un);
			eleUtil.doSendKeys(password, pwd);
			eleUtil.doClick(loginBtn);
			return new AccountsPage(driver);
			
			
		}
		
		public Boolean isForgotPwdLinkExist() {
			return eleUtil.doIsDisplayed(forgotPwdLink, Constants.DEFAULT_TIME_OUT);
		}

		public Boolean isregisterLinkExist() {
			return eleUtil.doIsDisplayed(registerLink, Constants.DEFAULT_TIME_OUT);		
			
		}
		
		
}
