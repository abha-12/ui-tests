package com.testing.ui.uibase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class UIBaseTest {
	public WebDriver driver;

	@BeforeSuite
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C://Users//kumar//Desktop//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://uitestingplayground.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@AfterSuite
	public void cleanup() {
		driver.quit();
	}
}
