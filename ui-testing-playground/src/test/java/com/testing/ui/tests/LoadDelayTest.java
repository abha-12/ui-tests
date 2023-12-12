package com.testing.ui.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class LoadDelayTest extends UIBaseTest {
	@Test
	public void loadDelayTest() {

		driver.findElement(By.linkText("Load Delay")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Button')]"))).click();
		System.out.println("Button clicked.");
	}

}
