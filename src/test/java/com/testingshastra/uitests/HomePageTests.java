package com.testingshastra.uitests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.pages.HomePage;
import com.testingshastra.pages.JoinMeetingPage;

public class HomePageTests extends BaseClass {

	
	UIKeywords keyword = UIKeywords.getInstance();
	
	@Test
	public void verifyTitleOfHomePage()
	{
		
		Assert.assertEquals(keyword.driver.getTitle(), "IJmeet");
	}
	
	@Test
	public void verifyIfUserRedirectsToJoinMeetingPage() throws InterruptedException
	{
		//POM
		HomePage home = new HomePage();
		
		home.rightclickonNavbar();
		Thread.sleep(5000);
		
		home.clickOnJoinMeetingTab();
		JoinMeetingPage joinMeeting = new JoinMeetingPage();
		
		String actual = joinMeeting.getQuickJoinMeetingTitle();
		System.out.println(actual);
		Assert.assertTrue(actual.contains("Quick"));
	}
	
	
	@Test
	public void printAllInfoLinks()
	{
		HomePage home = new HomePage();
		home.getTextOfInfoLinks();
	}
}
