package com.testing.ui.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testing.ui.uibase.UIBaseTest;

public class DynamicTableTest extends UIBaseTest {
	@Test
	public void dynamicTableTest() {
		
		//-------------------------------------------------------------------------------
		//Dynamic table based on divs with aria attributes. The values are dynamic
		//Scenario--find the value of cpu load(column) for chrome process(row)
		//-------------------------------------------------------------------------------

		int indexOfChrome = 0;
		driver.findElement(By.linkText("Dynamic Table")).click();
		//-------------------------------------
		//List of browsers-first column
		//Finding the row that contains 'chrome'
		//-------------------------------------
		List<WebElement> browsers = driver.findElements(By.xpath("//div[@role='rowgroup']/div[@role='row']/span[1]"));
		for (WebElement browser : browsers) {
			if (browser.getText().equals("Chrome")) {
				indexOfChrome = browsers.indexOf(browser);
				//System.out.println(indexOfChrome);
			}

		}
		//------------------------------------
		//Finding the column containing 'cpu'
		//------------------------------------
		int indexOfCPUHeader = 0;
		List<WebElement> headers = driver.findElements(By.xpath("//span[@role='columnheader']"));
		for (WebElement header : headers) {
			if (header.getText().equals("CPU")) {
				indexOfCPUHeader = headers.indexOf(header);
				//System.out.println(indexOfCPUHeader);
			}
		}
		//----------------------------------------------------------------------------
		//Finding the value of cpu load by iterating through the values in cpu column.
		//Compare with the value displayed on result bar
		//----------------------------------------------------------------------------
		List<WebElement> cpuColumn = driver
				.findElements(By.xpath("//div/div[@role='row']/span[" + (indexOfCPUHeader+1) + "]"));
		//System.out.println(cpuColumn.get(indexOfChrome).getText());
		String chromeCPU = cpuColumn.get(indexOfChrome).getText();
		System.out.println("chrome CPU from table : "+chromeCPU);

		String result = driver.findElement(By.xpath("//p[contains(text(),'CPU')]")).getText();
		System.out.println("result bar value : "+result);
		if (result.contains(chromeCPU)) {
			System.out.println("Success!!");
		}
		driver.navigate().back();

	}

}
