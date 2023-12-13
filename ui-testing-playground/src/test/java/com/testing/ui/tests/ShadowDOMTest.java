package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class ShadowDOMTest extends UIBaseTest {
	@Test
	public void shadowTest() {
		driver.findElement(By.linkText("Shadow DOM")).click();

		// -------------------------------------------------------------------------------
		// Elements inside a shadow DOM can not be located using regular id, name, xpath
		// locators. Define the shadowhost element and get the shadowRoot. Using the
		// ShadowRoot, locate the elements using CSS selector.
		// SearchContext is the interface that WebDriver extends from.
		// ----------------------------------------------------------------------------------

		// Scenario
		// Create a test that clicks on cogbutton and then on copyButton.This generates
		// a guid and copies to clipboard. Add an assertion step to the test to compare
		// the value from the clipboard with the value of the input field.
		//--------------------------------------------------------------------------------

		WebElement shadowHost = driver.findElement(By.cssSelector("guid-generator"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();
		WebElement cogBtn = shadowRoot.findElement(By.cssSelector("button#buttonGenerate"));
		WebElement copyBtn = shadowRoot.findElement(By.id("buttonCopy"));

		cogBtn.click();
		copyBtn.click();

		String textInput = shadowRoot.findElement(By.cssSelector("input#editField")).getText();
		Assert.assertTrue(copyBtn.getText().equals(textInput), "Copied text is not same as input text.");
	}

}
