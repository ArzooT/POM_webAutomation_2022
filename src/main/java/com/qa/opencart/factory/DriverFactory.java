package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.opencart.exceptions.FrameworkException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	OptionsManager OptionsManager;
    public static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	
	
	
	/**
	 * this method is used to initialize the webdriver on the basis of given browser
	 * name
	 * 
	 * @param
	 * @return it returns driver
	 */
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim();
		OptionsManager = new OptionsManager(prop);
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver(OptionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(OptionsManager.getChromeOptions()));
			
			
		} 
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(OptionsManager.getFirefoxOptions());
			//tlDriver.set(new FirefoxDriver(OptionsManager.getFirefoxOptions()));

			
		}
		else {
			System.out.println("Please pass correct browser  "+browserName);	
			
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		getDriver().get(prop.getProperty("url"));
		return getDriver();
		
	}
	
	

	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	/**
	 * this method is used to initialize the properties
	 */
	
	public Properties init_prop() {
		prop=new Properties();
		FileInputStream ip=null;
		String envName=System.getProperty("env");
		
		System.out.println("Running tests on env  "+envName);
		
		if(envName==null) {
			System.out.println("Since no env is provided, tests are running on QA env");
			try {
				ip= new FileInputStream("./src/test/resources/config/qa.config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			
			try {
			switch (envName.toLowerCase()) {
			
			
			case "qa":
				System.out.println("Running tests on QA envoirnment");
				ip= new FileInputStream("./src/test/resources/config/qa.config.properties");
 			break;
 			
			case "prod":
				System.out.println("Running tests on prod envoirnment");
				ip= new FileInputStream("./src/test/resources/config/config.properties");
 			break;
 			
			case "uat":
				System.out.println("Running tests on UAT envoirnment");
				ip= new FileInputStream("./src/test/resources/config/uat.config.properties");
 			break;
			
			default:
				System.out.println("Please pass corerct envoirnment"+envName);
				throw new FrameworkException("No env is found exception");
				//break;
			}
			
			}
		catch(Exception e) {
			
			
			}
		}
	
			
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return prop;
		
	}
	

}
	
