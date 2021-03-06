package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	public DriverFactory df;
	public WebDriver driver;
	public Properties prop;

	protected LoginPage loginPage;
	protected AccountsPage accPage;

	
	@BeforeTest
	public void setup()
	{
		df=new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		loginPage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
