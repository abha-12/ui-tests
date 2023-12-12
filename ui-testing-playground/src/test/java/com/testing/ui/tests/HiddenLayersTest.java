package com.testing.ui.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class HiddenLayersTest extends UIBaseTest{
	@Test
	public void hiddenLayersTest() {
		// Green button becomes hidden by an overlaid blue button which receives the
		// click after the first click.

		driver.findElement(By.linkText("Hidden Layers")).click();
		WebElement btn = driver.findElement(By.xpath("//button[text()='Button']"));
		String btnId = btn.getAttribute("id");
		btn.click();
		System.out.println("Button click 1 :" + btnId + " clicked.");

		List<WebElement> btns = driver.findElements(By.xpath("//button[text()='Button']"));
		for (WebElement b : btns) {
			try {
				b.click();
				System.out.println("Button click 2 :" + b.getAttribute("id") + " clicked.");
			} catch (ElementClickInterceptedException e) {
				System.out.println("Green Button not clickable." + e.getMessage());
			}
		}
		driver.navigate().back();
	}

}
