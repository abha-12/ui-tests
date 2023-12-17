package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class ProgressBarTest extends UIBaseTest {
	@Test
	public void progressBarTest() throws InterruptedException {
		driver.findElement(By.linkText("Progress Bar")).click();
		
		//============================================================================
		//Scenario-->Click start button, wait for progress bar to reach 75% and stop.
		//============================================================================
		
		WebElement stopButton = driver.findElement(By.id("stopButton"));
		WebElement progressBar = driver.findElement(By.id("progressBar"));
		String progress = progressBar.getAttribute("aria-valuenow");
		driver.findElement(By.id("startButton")).click();
		while (true) {
			progress = progressBar.getAttribute("aria-valuenow");
			if (progress.equals("75")) {
				stopButton.click();
				Thread.sleep(2000);
				System.out.println(progress);
				break;
			}
		}

	}

}
