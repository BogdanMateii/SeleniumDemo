package net.metrosystems.demo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class TestBaseSetup {
	
	protected WebDriver driver;

	@BeforeTest
	public void setDriverPath() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\APPS\\eclipse-workspace\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
	}

	/*
	 * @AfterTest public void closeBrowser() { driver.quit(); }
	 */
}
