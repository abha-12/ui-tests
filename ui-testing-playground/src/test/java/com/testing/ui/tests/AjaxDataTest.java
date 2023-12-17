package com.testing.ui.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class AjaxDataTest extends UIBaseTest {
	@Test
	public void ajaxRequestTest() {
		driver.findElement(By.linkText("AJAX Data")).click();
		//Click button and wait for label text to appear.
		
		driver.findElement(By.xpath("//button[contains(text(),'Button')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//p[contains(text(),'Data')]"),
				"Data loaded with AJAX get request."));
		driver.findElement(By.xpath("//p[contains(text(),'Data')]")).click();
	}

}
