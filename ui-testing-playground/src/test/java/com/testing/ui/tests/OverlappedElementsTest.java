package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class OverlappedElementsTest extends UIBaseTest {
	@Test
	public void overlappedTest() {
		driver.findElement(By.linkText("Overlapped Element")).click();

		// ==========================================================================
		// textbox which is partially visible need to be scrolled into view before
		// entering text.
		// ==========================================================================

		driver.findElement(By.id("id")).sendKeys("myId");
		WebElement nameBox = driver.findElement(By.id("name"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nameBox);
		nameBox.sendKeys("myName");

	}

}
