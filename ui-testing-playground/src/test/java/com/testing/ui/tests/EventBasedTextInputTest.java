package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class EventBasedTextInputTest extends UIBaseTest {
	@Test
	public void textInputTest() {
		driver.findElement(By.linkText("Text Input")).click();
		// Event-based Text input not being recognized by input field

		WebElement textInputBox = driver.findElement(By.id("newButtonName"));
		WebElement updatingButton = driver.findElement(By.id("updatingButton"));

		Actions actions = new Actions(driver);
		System.out.println("Button text before click : " + updatingButton.getText());
		actions.sendKeys(textInputBox, "NewButton");
		updatingButton.click();
		updatingButton = driver.findElement(By.id("updatingButton"));
		System.out.println("Button text after event-based text update : " + updatingButton.getText());
		
		if (updatingButton.getText().equals("Button That Should Change it's Name Based on Input Value")) {
			textInputBox.sendKeys("NewButton");
			updatingButton.click();
			updatingButton = driver.findElement(By.id("updatingButton"));
			System.out.println("Button text after physical text update. : " + updatingButton.getText());
		}

	}

}
