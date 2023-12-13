package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class LocateByTextTest extends UIBaseTest {
	@Test
	public void verifyTextTest() {
		// Searching for an element using text value when inner text of the DOM element
		// is different from that on screen.
		driver.findElement(By.linkText("Verify Text")).click();
		WebElement welcomeTxt = driver.findElement(By.xpath("//span[contains(text(),'Welcome ')]"));
		System.out.println("Text of the element is : " + welcomeTxt.getText());

	}

}
