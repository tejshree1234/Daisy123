package com.testingshastra.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIkeywords;

public class JoinMeetingPage {
	UIkeywords keyword = UIkeywords.getInstance();
	
	@FindBy(css="div.joinmeeting")
	public WebElement QuickJoinMeetingTitle;
	
	public JoinMeetingPage() {
		PageFactory.initElements(keyword.driver, this);
	}
	
	
	public String getQuickJoinMeetingTitle() {
		return QuickJoinMeetingTitle.getText();
		
		
	}

}
