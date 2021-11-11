package com.testingshastra.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testingshastra.config.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

//singletone class code.
public class UIKeywords {

	/**
	 * @author MOHASIN BADASHAHA TAMBOLI
	 * @param browserName
	 */

	public static RemoteWebDriver driver = null;

	private static UIKeywords uikeywords; // single copy

	static {
		uikeywords = new UIKeywords();
	}

	private UIKeywords() {

	}

	public static UIKeywords getInstance() {

		return uikeywords;
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	public void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.err.println("invalid browser name" + browserName);

		}

	}

	public void launchUrl(String url) 
	{
		driver.get(url);
	}

	public void click(WebElement element) 
	{
		element.click();
	}

	public void enterText(WebElement element, String textToEnter) 
	{
		element.sendKeys(textToEnter);
	}

	@Deprecated
	public void enterText(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public void enterText(String object, String textToEnter) 
	{
		String parts[] = object.split("##");
		getWebElement(parts[0], parts[1]).sendKeys(textToEnter);
	}

	public String getTitleOfPage() 
	{
		return driver.getTitle();
	}

	public void maximizeWindow() 
	{
		driver.manage().window().maximize();
	}

	public void click(String locatorType, String locatorValue)
	{

		getWebElement(locatorType, locatorValue).click();

	}

	public String getCurrentUrl() 
	{
		return driver.getCurrentUrl();
	}

	public void switchToFrameAt(int index)
	{
		driver.switchTo().frame(index);
	}

	public void delAllCookies()
	{
		driver.manage().deleteAllCookies();

	}
	
	public void delCookieWithName(String cookieName)
	{
		driver.manage().deleteCookieNamed(cookieName);
        
	}
	
	
	
	public void switchToFrame(String idorname) {
		driver.switchTo().frame(idorname);
	}

	public void switchToFram(WebElement frame) 
	{
		driver.switchTo().frame(frame);
	}

	public void switchToDefaultContent() {

		driver.switchTo().defaultContent();
	}

	public WebElement getWebElement(String locatorType, String locatorValue)
	{

		WebElement element = null;

		if (locatorType.equalsIgnoreCase("xpath")) {
			element = driver.findElement(By.xpath(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("class")) {
			element = driver.findElement(By.className(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("id")) {
			element = driver.findElement(By.id(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("tag")) {
			element = driver.findElement(By.tagName(locatorValue));
		}
		if (locatorType.equalsIgnoreCase("css")) {
			element = driver.findElement(By.cssSelector(locatorValue));
		}

		return element;

	}
}
