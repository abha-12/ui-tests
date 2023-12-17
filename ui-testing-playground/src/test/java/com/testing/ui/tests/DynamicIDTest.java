package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class DynamicIDTest extends UIBaseTest{
	@Test
	public void dynamicIdTest() {
		driver.findElement(By.linkText("Dynamic ID")).click();
		
		//------------------------------------------------------------------------------------
		//Locating button with dynamic ID
		//Text of button used to define locator
		//------------------------------------------------------------------------------------
		
		driver.findElement(By.xpath("//button[contains(text(),'Dynamic')]")).click();
		System.out.println("Dynamic ID button clicked.");
		driver.navigate().back();
	}

}
