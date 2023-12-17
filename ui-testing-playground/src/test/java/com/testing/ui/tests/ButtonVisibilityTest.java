package com.testing.ui.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class ButtonVisibilityTest extends UIBaseTest {
	@Test
	public void visibilityTest() {
		//---------------------------------------------------------------------
		//Checking for the presence and visibility of different buttons
		//---------------------------------------------------------------------
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.linkText("Visibility")).click();
		WebElement hideButton = driver.findElement(By.xpath("//button[text()='Hide']"));
		WebElement removedButton = driver.findElement(By.xpath("//button[text()='Removed']"));
		WebElement zeroWidthButton = driver.findElement(By.xpath("//button[text()='Zero Width']"));
		WebElement overlappedButton = driver.findElement(By.xpath("//button[text()='Overlapped']"));
		WebElement opacityButton = driver.findElement(By.xpath("//button[text()='Opacity 0']"));
		WebElement visibilityHiddenButton = driver.findElement(By.xpath("//button[text()='Visibility Hidden']"));
		WebElement displayNoneButton = driver.findElement(By.xpath("//button[text()='Display None']"));
		WebElement offscreenButton = driver.findElement(By.xpath("//button[text()='Offscreen']"));

		hideButton.click();
		boolean isRemovedButtonPresent = (driver.findElements(By.xpath("//button[text()='Removed']")).size() > 0);
		System.out.println("Removed button present? : " + isRemovedButtonPresent);
		if (isRemovedButtonPresent) {
			System.out.println("Removed button displayed? : " + removedButton.isDisplayed());
		} else {
			System.out.println("Removed button not displayed.");
		}
		System.out.println();

		boolean isZeroWidthButtonPresent = driver.findElements(By.xpath("//button[text()='Zero Width']")).size() > 0;
		System.out.println("zeroWidthButton present? : " + isZeroWidthButtonPresent);
		if (isZeroWidthButtonPresent) {
			System.out.println("zero width button displayed? : " + zeroWidthButton.isDisplayed());
		} else {
			System.out.println("Zero width button not displayed.");
		}
		System.out.println();

		boolean isOverlappedButtonPresent = driver.findElements(By.xpath("//button[text()='Overlapped']")).size() > 0;
		System.out.println("Overlapped button present? : " + isOverlappedButtonPresent);
		if (isOverlappedButtonPresent) {
			System.out.println("Overlapped button displayed? : " + overlappedButton.isDisplayed());
		} else {
			System.out.println("Overlapped button not displayed.");
		}
		System.out.println();

		boolean isOpacityButtonPresent = driver.findElements(By.xpath("//button[text()='Opacity 0']")).size() > 0;
		System.out.println("Opacity button present? : " + isOpacityButtonPresent);
		if (isOpacityButtonPresent) {
			System.out.println("Opacity button displayed? : " + opacityButton.isDisplayed());
		} else {
			System.out.println("Opacity button not displayed.");
		}
		System.out.println();

		boolean isVisibilityHiddenButtonPresent = driver.findElements(By.xpath("//button[text()='Visibility Hidden']"))
				.size() > 0;
		System.out.println("Visibility Hidden button present? : " + isVisibilityHiddenButtonPresent);
		if (isVisibilityHiddenButtonPresent) {
			System.out.println("Visibility hidden button displayed? : " + visibilityHiddenButton.isDisplayed());
		} else {
			System.out.println("Visibility hidden button not displayed.");
		}
		System.out.println();

		boolean isDisplayNoneButtonPresent = driver.findElements(By.xpath("//button[text()='Display None']"))
				.size() > 0;
		System.out.println("Display None button present? : " + isDisplayNoneButtonPresent);
		if (isDisplayNoneButtonPresent) {
			System.out.println("Display None button displayed? : " + displayNoneButton.isDisplayed());
		} else {
			System.out.println("Display None button not displayed.");
		}
		System.out.println();

		boolean isOffscreenButtonPresent = driver.findElements(By.xpath("//button[text()='Offscreen']")).size() > 0;
		System.out.println("Offscreen button present? : " + isOffscreenButtonPresent);
		if (isOffscreenButtonPresent) {
			System.out.println("Offscreen button displayed? : " + offscreenButton.isDisplayed());
		} else {
			System.out.println("Offscreen button not displayed.");
		}

		driver.navigate().back();
	}

}
