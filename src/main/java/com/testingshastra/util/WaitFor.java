package com.testingshastra.util;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testingshastra.keywords.UIKeywords;

public class WaitFor {

	private static final WebDriverWait wait;
	
	
	
	static
	{
		wait = new WebDriverWait(UIKeywords.getInstance().driver, 10);
		wait.pollingEvery(Duration.ofMillis(500));
		
	}
	
	public static void visibilityofElement(WebElement element , long duration)
	{
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	public void stalenessOf(WebElement element , int duration)
	{
		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.stalenessOf(element));
		
	}
	
	
	
	public static void elementToBeClickable(WebElement element )
	{
		wait.withTimeout(Duration.ofSeconds(30));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.stalenessOf(element));
		
	}
	
}
