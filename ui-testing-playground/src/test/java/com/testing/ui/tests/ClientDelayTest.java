package com.testing.ui.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class ClientDelayTest extends UIBaseTest {
	@Test
	public void clientSideDelayTest() throws InterruptedException {
		driver.findElement(By.linkText("Client Side Delay")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[contains(text(),'Trigger')]")).click();

		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.id("content")),
				"Data calculated on the client side."));
		driver.navigate().back();
	}

}
