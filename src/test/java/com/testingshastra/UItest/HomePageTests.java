package com.testingshastra.UItest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.confg.BaseClass;
import com.testingshastra.keywords.UIkeywords;
import com.testingshastra.pages.HomePage;

import com.testingshastra.pages.JoinMeetingPage;

public class HomePageTests extends BaseClass{
	UIkeywords keyword = UIkeywords.getInstance();

	@Test
	public void VerifyTitleOfHomePgae() {

		String expectedTitle =" IJmeet";
		Assert.assertEquals(keyword.driver.getTitle(), expectedTitle);
	}
	
	@Test
	public void VerifyusertojoinMeetingpage() {
		
		HomePage home = new HomePage();
		
		home.clickonJoinMeetingTab();
		
		JoinMeetingPage joinMeeting = new JoinMeetingPage();
		
		String actual = joinMeeting.getQuickJoinMeetingTitle();
		Assert.assertTrue(actual.contains("Quick"));
		

	}
	
	@Test
	public void printallinfolinks() {


		HomePage home = new HomePage();
		home.getTextInfoLinks();
	}
}
