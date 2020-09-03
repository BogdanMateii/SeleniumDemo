package net.metrosystems.demo.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import net.metrosystems.demo.utils.DriverInit;

public class AlertsTest extends DriverInit {
	Alert alert;
	WebElement jsResult;
	WebElement jsAlert;	
	WebElement jsConfirm;
	WebElement jsPrompt;

	String jsResultStr = "result";
	String jsAlertStr = "//ul/li/button[text()='Click for JS Alert']";	
	String jsConfirmStr = "//ul/li/button[text()='Click for JS Confirm']";
	String jsPromptStr = "//ul/li/button[text()='Click for JS Prompt']";
	

	@Test(priority = 0)
	public void openPage() {
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		assertEquals(driver.getTitle(), "The Internet");
	}

	@Test
	public void verifyJSAlert() {
		jsAlert = driver.findElement(By.xpath(jsAlertStr));
		jsAlert.click();
		alert = driver.switchTo().alert();
		String jsAlertMessage = alert.getText();
		System.out.println(jsAlertMessage);
		alert.accept();

		jsResult = driver.findElement(By.id(jsResultStr));
		assertEquals(jsResult.getText(), "You successfuly clicked an alert");
	}
	
	@Test
	public void verifyJSConfirm() {
		jsConfirm = driver.findElement(By.xpath(jsConfirmStr));
		jsConfirm.click();
		alert = driver.switchTo().alert();
		String jsConfirmMessage = alert.getText();
		System.out.println(jsConfirmMessage);
		alert.dismiss();

		jsResult = driver.findElement(By.id(jsResultStr));
		assertEquals(jsResult.getText(), "You clicked: Cancel");
	}
	
	@Test
	public void verifyJSPrompt() {
		jsPrompt = driver.findElement(By.xpath(jsPromptStr));
		jsPrompt.click();
		alert = driver.switchTo().alert();
		String jsPromptMessage = alert.getText();
		System.out.println(jsPromptMessage);
		alert.sendKeys("Test");
		alert.accept();

		jsResult = driver.findElement(By.id(jsResultStr));
		assertTrue(jsResult.getText().contains("You entered: "));
		
	}
}

//metoda 1: tratez primul popup, deschid, citesc text, inchide //citesc I am a JS Alert; dupa assert pe textul You successfuly clicked an alert
//metoda 2: tratez primul dismiss  //assert pe textul 
//metoda 3: tratez // asert doar pe textul: You entered: 
//https://the-internet.herokuapp.com/javascript_alerts
