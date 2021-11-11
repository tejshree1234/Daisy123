package com.testingshastra.config;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.util.PropertiesFile;

public class BaseClass {

	UIKeywords keyword = UIKeywords.getInstance();

	public RemoteWebDriver driver = null;

	@Parameters("browser-name")
	@BeforeMethod
	public void setup(@Optional String browserName) 
	{
		Application app = new Application();
		
		if(browserName==null)
		{
			browserName=app.getBrowser();
		}
		
		keyword.openBrowser(browserName);
		this.driver = keyword.getDriver();
		driver.get(app.getAppUrl());
	}

	@AfterMethod
	public void tearDown() 
	{
		keyword.quitBrowser();
	}

}
