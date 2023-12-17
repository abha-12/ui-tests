package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class NonBreakingSpaceTest extends UIBaseTest {
	@Test
	public void nbspTest() {
		driver.findElement(By.linkText("Non-Breaking Space")).click();

		// ============================================================================================
		// The element on DOM shows 'My&nbspButton' as the text of the element. xpath
		// with text value 'My Button' will not work. Replace nbsp with its
		// unicode(\u00a0) in xpath.
		// ============================================================================================

		try {
			WebElement myButton = driver.findElement(By.xpath("//button[text()='My Button']"));
		} catch (NoSuchElementException e) {
			WebElement myBtn = driver.findElement(By.xpath("//button[text()='My\u00a0Button']"));
			if (myBtn.getText().equals("My Button")) {
				System.out.println("Successfully located element with &nbsp");
			}
		}
	}

}
