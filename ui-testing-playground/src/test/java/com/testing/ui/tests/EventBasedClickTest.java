package com.testing.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class EventBasedClickTest extends UIBaseTest {
	@Test
	public void clickTest() {
		driver.findElement(By.linkText("Click")).click();
		//-----------------------------------------
		//Button ignoring event-based click
		//-----------------------------------------
		
		Actions actions = new Actions(driver);
		WebElement ignoreBtn = driver.findElement(By.xpath("//button[contains(text(),'Ignores')]"));
		actions.moveToElement(ignoreBtn).click();
		
		//checking whether click is successful.
		//If unsuccessful, perform a physical click.
		
		ignoreBtn = driver.findElement(By.xpath("//button[contains(text(),'Ignores')]"));
		if(ignoreBtn.getAttribute("class").equals("btn btn-success")) {
			System.out.println("Button click successful");
		}else {
			System.out.println("Status of event-based click : "+ignoreBtn.getAttribute("class"));
			ignoreBtn.click();
			System.out.println("status after physical click : "+ignoreBtn.getAttribute("class"));
		}
	}

}
