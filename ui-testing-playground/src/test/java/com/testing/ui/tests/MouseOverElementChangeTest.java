package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class MouseOverElementChangeTest extends UIBaseTest {
	@Test
	public void mouseOverTest() {
		driver.findElement(By.linkText("Mouse Over")).click();
		
		//The link changes after the first click, resulting StaleElementReference on Second click
		//Relocate the element before the second click.

		WebElement clickMeLink = driver.findElement(By.linkText("Click me"));
		WebElement clickCount = driver.findElement(By.id("clickCount"));

		System.out.println("Click count before clicks : " + clickCount.getText());

		clickMeLink.click();
		try {
			clickMeLink.click();
		} catch (StaleElementReferenceException e) {
			clickMeLink = driver.findElement(By.linkText("Click me"));
			clickMeLink.click();
		}

		clickCount = driver.findElement(By.id("clickCount"));
		System.out.println("Click count after clicks : " + clickCount.getText());
		
		if(clickCount.getText().equals("2")) {
			System.out.println("Successfully clicked the link twice.");
		}

	}

}
