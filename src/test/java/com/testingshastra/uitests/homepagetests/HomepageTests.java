package com.testingshastra.uitests.homepagetests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.config.BaseClass;
import com.testingshastra.keywords.UIKeywords;
import com.testingshastra.pages.HomePage;

public class HomepageTests extends BaseClass {
	
	
	
	UIKeywords keyword =  UIKeywords.getInstance();
	
	
	public void verifyTitleOfHomePage()
	{
	    keyword.launchUrl("https://www.testingshastra.com");
	    keyword.maximizeWindow();
	    keyword.delAllCookies();
		String title= keyword.getTitleOfPage();
		Assert.assertEquals(title,"Testing Shastra | Training | Placement");
		
	}
	
	@Test
	public void validateAllLinksOfHomePage() throws MalformedURLException, IOException
	{
		HomePage home = new HomePage();
	    List<WebElement> links =	home.getAllLinks();
	    Iterator<WebElement> itr = links.iterator();
	    while(itr.hasNext())
	    {
	      String url=itr.next().getAttribute("href");
	      HttpsURLConnection con = (HttpsURLConnection)new URL(url).openConnection();
	      int code= con.getResponseCode();
	      Assert.assertFalse(code>400,"Link is Broken : "+url);
	      
	    }
	}

}
