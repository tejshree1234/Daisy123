package com.testingshastra.pages;



import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIkeywords;

public class HomePage {
	
	UIkeywords keyword = UIkeywords.getInstance();
	
	@FindBy(css="div#navbarContent li:nth-child(1)")
	public WebElement joinMeetingTab;
	
	@FindBy(css="div.footer-last-view-support div:nth-child(3) li a")
	public List<WebElement> infoLinks;
	
	public HomePage() {
		PageFactory.initElements(keyword.driver, this);
	}
		

	public void clickonJoinMeetingTab() {
		joinMeetingTab.click();

	}
	public void getTextInfoLinks() {

		Iterator<WebElement> itr = infoLinks.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next().getText());
		}
	}
	}


