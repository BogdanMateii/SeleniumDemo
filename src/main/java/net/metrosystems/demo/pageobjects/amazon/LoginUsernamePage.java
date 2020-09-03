package net.metrosystems.demo.pageobjects.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.metrosystems.demo.utils.DriverInit;
import net.metrosystems.demo.utils.SeleniumWrappers;

public class LoginUsernamePage extends SeleniumWrappers {

	public LoginUsernamePage(WebDriver driver) {
		DriverInit.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ap_email")
	public WebElement emailInput;
	
	@FindBy(id = "continue")
	public WebElement continueBtn;


}
