package net.metrosystems.demo.pageobjects.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.metrosystems.demo.utils.SeleniumWrappers;

public class HeaderPage extends SeleniumWrappers{
	WebDriverWait wait;		

	@FindBy(id = "nav-link-accountList")
	public WebElement signInBtn;

}
