package com.testingshastra.confg;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testingshastra.keywords.UIkeywords;

public class BaseClass {
	UIkeywords keyword = UIkeywords.getInstance();
	public RemoteWebDriver driver = null;

	@BeforeMethod
	public void Setup() {
		keyword.openbrowser("chrome");
		this.driver = keyword.getDriver();
		driver.get("https://www.ijmeet.com");

	}

	@AfterMethod
	public void tearDown() {
		keyword.quiteBrowser();
	}

}
