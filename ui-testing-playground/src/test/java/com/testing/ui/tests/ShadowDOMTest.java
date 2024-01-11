package com.testing.ui.tests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

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

		// =================================================================================
		// Elements inside a shadow DOM can not be located using regular id, name, xpath
		// locators. Define the shadowhost element and get the shadowRoot. Using the
		// ShadowRoot, locate the elements using CSS selector or id.
		// SearchContext is the interface that WebDriver extends from.
		// =================================================================================

		// Scenario
		// Create a test that clicks on cogbutton and then on copyButton.This generates
		// a guid and copies to clipboard. Add an assertion step to the test to compare
		// the value from the clipboard with the value of the input field.
		// http://uitestingplayground.com
		// ==================================================================================

		WebElement shadowHost = driver.findElement(By.cssSelector("guid-generator"));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		// locating the guid generator
		// -------------------------------
		WebElement cogBtn = shadowRoot.findElement(By.cssSelector("button#buttonGenerate"));
		cogBtn.click();

		// retrieving the value of guid generated
		// --------------------------------------
		String textInput = shadowRoot.findElement(By.cssSelector("input#editField")).getAttribute("value");
		System.out.println("Text input generated : " + textInput);

		// click on the copy button
		// ------------------------
		shadowRoot.findElement(By.cssSelector("button#buttonCopy")).click();

		// retrieving value in system clipboard and comparing against the id generated.
		// ----------------------------------------------------------------------------
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Clipboard clipboard = toolkit.getSystemClipboard();

		String clipBoardText = null;
		try {
			clipBoardText = (clipboard.getData(DataFlavor.stringFlavor)).toString();
		} catch (UnsupportedFlavorException | IOException e) {
			e.printStackTrace();

		}
		System.out.println("Copied text : " + clipBoardText);

		Assert.assertTrue(clipBoardText.equals(textInput), "Copied text is not same as input text.");

	}

}
