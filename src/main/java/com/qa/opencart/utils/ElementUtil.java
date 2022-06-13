package com.qa.opencart.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

public class ElementUtil {

	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	/**
	 * An expectation for checking the title of a page.
	 * 
	 * @param title
	 * @param timeOut
	 * @return
	 */
	
	public String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
			
		}
		return null;
		
	}
	
	public String waitForUrlContains(String urlFraction,int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
			
		}
		return null;
		
	}
	
	public WebElement waitForElementVisible(By Locator,int timeOut) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
			
		
	}
	
	public WebElement getElement(By Locator) {
		return driver.findElement(Locator);
		
	}
	
	public void doSendKeys(By Locator,String value) {
		WebElement ele=getElement(Locator);
		ele.clear();
		ele.sendKeys(value);
		
	}
	public void doClick(By Locator) {
		getElement(Locator).click();
	}
	
	public Boolean doIsDisplayed(By Locator,int timeOut) {

		return getElement(Locator).isDisplayed();
		
	}
	
}
