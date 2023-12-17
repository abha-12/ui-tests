package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class ScrollbarTest extends UIBaseTest {
	@Test
	public void scrollBarTest() throws InterruptedException {
		driver.findElement(By.linkText("Scrollbars")).click();
		
		//============================================================================
		//Scenario--> Find a hidden button by scrolling into view and click on it.
		//============================================================================
		
		WebElement hiddenButton = driver.findElement(By.id("hidingButton"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", hiddenButton);
		Thread.sleep(3000);
		hiddenButton.click();
		Thread.sleep(3000);

	}

}
