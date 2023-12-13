package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class SampleAppTest extends UIBaseTest{
	@Test
	public void loginTest() {
		driver.findElement(By.linkText("Sample App")).click();
		
		WebElement loginStatus= driver.findElement(By.id("loginstatus"));
		System.out.println("Initial login status : "+ loginStatus.getText());
		
		driver.findElement(By.name("UserName")).sendKeys("user");
		driver.findElement(By.name("Password")).sendKeys("pwd");
		driver.findElement(By.id("login")).click();
		
		loginStatus= driver.findElement(By.id("loginstatus"));
		System.out.println("Login status after clicking login : "+ loginStatus.getText());
	}

}
