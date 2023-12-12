package com.testing.ui.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class DynamicTableTest extends UIBaseTest {
	@Test
	public void dynamicTableTest() {

		int indexOfChrome = 0;
		driver.findElement(By.linkText("Dynamic Table")).click();
		List<WebElement> browsers = driver.findElements(By.xpath("//div[@role='rowgroup']/div[@role='row']/span[1]"));
		for (WebElement browser : browsers) {
			if (browser.getText().equals("Chrome")) {
				indexOfChrome = browsers.indexOf(browser);
				System.out.println(indexOfChrome);
			}

		}
		int indexOfCPUHeader = 0;
		List<WebElement> headers = driver.findElements(By.xpath("//span[@role='columnheader']"));
		for (WebElement header : headers) {
			if (header.getText().equals("CPU")) {
				indexOfCPUHeader = headers.indexOf(header);
				System.out.println(indexOfCPUHeader);
			}
		}
		List<WebElement> cpuColumn = driver
				.findElements(By.xpath("//div/div[@role='row']/span[" + indexOfCPUHeader + "]"));
		System.out.println(cpuColumn.size());
		System.out.println(cpuColumn.get(indexOfChrome).getText());
		String chromeCPU = cpuColumn.get(indexOfChrome).getText();

		String result = driver.findElement(By.xpath("//p[contains(text(),'CPU')]")).getText();
		if (result.contains(chromeCPU)) {
			System.out.println("Success!!");
		}
		driver.navigate().back();

	}

}
