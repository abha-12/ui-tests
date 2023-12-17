package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class ClassAttributeTest extends UIBaseTest{
	@Test
	public void classAttributeTest() {
		//-----------------------------------------------------------------------
		//Class attribute containing more than one class reference
		//-----------------------------------------------------------------------
		
		driver.findElement(By.linkText("Class Attribute")).click();
		driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]")).click();
		driver.switchTo().alert().accept();
		driver.navigate().back();
	}

}
