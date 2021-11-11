package com.testingshastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIKeywords;

public class JoinMeetingPage {

	UIKeywords keyword =  UIKeywords.getInstance();
	
	@FindBy(css="div.joinmeeting")
	public WebElement quickJoinMeetingTitle;
	
	public String getQuickJoinMeetingTitle()
	{
		return quickJoinMeetingTitle.getText();
	}
	
	
	
	public JoinMeetingPage()
	{
		PageFactory.initElements(keyword.driver,this); // lazy loading lazy proxy
	}
}
