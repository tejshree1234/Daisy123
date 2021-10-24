package com.testingshastra.UItest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.testingshastra.confg.BaseClass;
import com.testingshastra.keywords.UIkeywords;
import com.testingshastra.util.Locator;
import com.testingshastra.util.WaitFor;


public class SignUppageIJmeet extends BaseClass{
	
	private static final Logger LOG = Logger.getLogger(SignUppageIJmeet.class);
	UIkeywords keyword = UIkeywords.getInstance();
	
	@Test
	public void validateFirstNameField() {
		/**
		 * //Approch 1
		 * keyword.launchurl("https://www.ijmeet.com");
		WebElement signUp = keyword.getDriver().findElement(By.cssSelector("li:nth-child(5) a.nav-link"));
		keyword.click(signUp);
		 */
		
		
		//Approach 2
		String url ="https://www.ijmeet.com";
		keyword.launchurl(url);
		LOG.info("url is launhed"+url);
		keyword.click("css","li:nth-child(5) a.nav-link");
		LOG.info("click on register button");
		keyword.enterText(Locator.SIGNUP_FULLNAME ,"Tejashree kakade");
		keyword.enterText(Locator.SIGNUP_COMPANYNAME ,"Testing Shastra");
		
		keyword.enterText(Locator.SIGNUP_EMAIL,"testingshastra@gmail.com");
		keyword.enterText(Locator.SIGNUP_CONTACT,"9653829433");
		keyword.enterText(Locator.SIGNUP_PASSWORD,"testing12345");
		
		keyword.switchToFrame(0);
		LOG.info("switch inside a frame");
		WaitFor.elementtoClickable(keyword.getWebElement("css", "div.recaptcha-checkbox-border"));
		keyword.click("css","div.recaptcha-checkbox-border");
		keyword.switchToDefaultContent();
		LOG.info("jumped back form frame");
		keyword.click("css","button[type='submit]");
		String actualUrl = keyword.getCurrentUrl();
		Assert.assertTrue(actualUrl.contains("dashboard"));
		
	}
	

}
