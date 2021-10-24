package com.testingshastra.UItest.homepagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testingshastra.confg.BaseClass;
import com.testingshastra.keywords.UIkeywords;

@Test
public class HomePageTest extends BaseClass {
		
	UIkeywords keyword = UIkeywords.getInstance();
	String expectedTitle = "Testing Shastra | Training | Placement";
	

	public void verifyhomepageoftitle() {

		keyword.launchurl("https://www.testingshastra.com");
		String title = keyword.getTitleofPage();
		Assert.assertEquals(title, expectedTitle);
	}

}
