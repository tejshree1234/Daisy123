package com.testingshastra.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v93.browser.Browser;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UIkeywords {
	
 // private static final RemoteWebDriver RemoteWebDriver = null;
	/**
	 * This is singletone class to create object of this class, use code getInstance() method
	 */

	public RemoteWebDriver driver = null;
	private static UIkeywords uikeywords;
	static{
		uikeywords = new UIkeywords();
	}
	
	public static UIkeywords getInstance() {
		return uikeywords;
	}
	private UIkeywords() {
	
	}
	
	/**

	 * This keyword is used for browser
	 * @param browser name must be following 
	 * 
	 * <ul>
	 * <li> chrome </li>
	 * <li> firefox </li>
	 * <li> internet explorer </li>
	 * </ul>
	 * 
	 * @author tejashree kakade

	 */
	
	public void openbrowser(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
		}else
		{
			System.err.println("invalid browser name" +browserName);
		}
			
	}
	
	public void closebrowser() {
		Browser.close();

	}
	
	public void quiteBrowser() {
		driver.quit();

	}
	
	public void launchurl(String url) {
		driver.get(url);

	}
	
	public void click(WebElement element) {
		element.click();

	}
	
	public void enterText(WebElement element, String toenterText) {
		element.sendKeys(toenterText);
	}
	@Deprecated
	public void enterText(String locatortype, String locatorvalue, String textToEnter) {
		getWebElement(locatortype,locatorvalue).sendKeys(textToEnter);
	}
	
	public void enterText(String object, String textToEnter) {
		
		String[] parts = object.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);
	}
	
	public WebElement getWebElement(String locatortype, String locatorvalue) {
		WebElement element = null;
		if(locatortype.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorvalue));
		}
		if(locatortype.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorvalue));
		}
		if(locatortype.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorvalue));	
		}
		if(locatortype.equalsIgnoreCase("name")) {
			element = driver.findElement(By.name(locatorvalue));
		}
		if(locatortype.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locatorvalue));
		}
		if(locatortype.equalsIgnoreCase("tag")) {
			element = driver.findElement(By.tagName(locatorvalue));
		}
		return element;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
		

	}
		
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);

	}

	
	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();

	}
	public String getTitleofPage() {
		return driver.getTitle();
	}

	public void click(String locatortype, String locatorvalue) {
		getWebElement(locatortype,locatorvalue).click();
		
	}
	public RemoteWebDriver getDriver() {
		
		return driver;
	}
	
	}
	

