package com.testingshastra.util;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testingshastra.keywords.UIkeywords;

public class WaitFor {

	private static final WebDriverWait wait;

	static {
		wait = new WebDriverWait(UIkeywords.getInstance().driver, Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(500));
	}

	public static void visibilityofElement(WebElement element, long duration) {

		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void stalessof(WebElement element, int duration) {

		wait.withTimeout(Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	/*
	 * This method waits for element to be clickable.
	 * Max timeout is 30 seconds which is not configration
	 * 
	 */
	
	public static void elementtoClickable(WebElement element) {

		wait.withTimeout(Duration.ofSeconds(30));
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
