package net.metrosystems.demo.utils;

import java.util.Base64;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends DriverInit {
	WebDriverWait wait;

	public void click(WebElement selector) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(selector));
		try {
			selector.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void click(List<WebElement> selector, int index) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements(selector));
		List<WebElement> elements = driver.findElements((By) selector);
		try {
			elements.get(index).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKeys(WebElement selector, String value) {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(selector));
		try {
			selector.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCurrentTitle() {
		return driver.getTitle();
	}

	public static String decodedStringPropertiesFile(String value) { // not working with try catch
		String decodedString = null;
		try {
			String encodedString = PropertiesLoad.config.getProperty(value);
			byte[] decodedBytes = Base64.getUrlDecoder().decode(encodedString);
			decodedString = new String(decodedBytes);
		} catch (Exception e) {			
			//e.printStackTrace();
			throw new TestException(e);
		}
		return decodedString;

//	public wait until 
	}
}

//testng TestException - read
//
