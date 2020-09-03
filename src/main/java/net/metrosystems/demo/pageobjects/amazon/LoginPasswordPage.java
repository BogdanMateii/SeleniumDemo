package net.metrosystems.demo.pageobjects.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.metrosystems.demo.utils.DriverInit;
import net.metrosystems.demo.utils.SeleniumWrappers;

public class LoginPasswordPage extends SeleniumWrappers {

	public LoginPasswordPage(WebDriver driver) {
		DriverInit.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ap_password")
	public WebElement passwordInput;
	
	@FindBy(id = "signInSubmit")
	public WebElement signInBtn;

}
