package net.metrosystems.demo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverInit {

	public static WebDriver driver;
	public static String browser = PropertiesLoad.config.getProperty("browser");

	public static WebDriver setDriverPath() {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			// return driver;

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "drivers/firefoxdriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			// return driver;
		} else {
			//mesaj eroare
		}
		return driver;
	}
}
/*
 * @AfterTest public void closeBrowser() { driver.quit(); }
 */
