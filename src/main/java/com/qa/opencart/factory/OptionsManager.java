package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private ChromeOptions co;
	private Properties prop;
	private FirefoxOptions fo;
	
	
	
	public OptionsManager(Properties prop) {
		
		this.prop=prop;
		
	}

	public ChromeOptions getChromeOptions() {
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.setHeadless(true);
						
		}
		else if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
			
		}
		return co;
		
		
	}
	
	public FirefoxOptions getFirefoxOptions() {
		
		fo=new FirefoxOptions ();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.setHeadless(true);
						
		}
		else if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
			
		}
		return fo;
		
		
	}
}
