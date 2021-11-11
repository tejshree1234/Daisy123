package com.testingshastra.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshastra.keywords.UIKeywords;

public class HomePage {

	UIKeywords keyword =  UIKeywords.getInstance();
	
	@CacheLookup
	@FindBy(css="div#navbarContent li:nth-child(1)")
	public WebElement joinMeetingTab;
	
	
	@FindBy(id= "navbarContent")
	public WebElement navbarContent;
	
	
	
	@FindBy(css="a[href*='host_meeting'] ")
	public WebElement hostMeetingTab;
	
	@FindBy(css="div.footer-last-view-support div:nth-child(3) li a")
	public List<WebElement> infoLinks;
	
	
	//constructor
	
	public HomePage()
	{
		
		PageFactory.initElements(keyword.driver, this);
	}
	
	public List<WebElement> getAllLinks()
	{
		return keyword.driver.findElements(By.tagName("a"));
	}
	
	public void clickOnJoinMeetingTab() 
	{
		joinMeetingTab.click();
		
	}
	
	public void getTextOfInfoLinks()
	{
		Iterator<WebElement> itr = infoLinks.iterator();
		while(itr.hasNext())
		{
			
			System.out.println(itr.next().getText());
		}
	}
	
	public void rightclickonNavbar()
	{
		Actions act = new Actions(keyword.driver);
		act.contextClick(navbarContent).build().perform();
	}
	
}
