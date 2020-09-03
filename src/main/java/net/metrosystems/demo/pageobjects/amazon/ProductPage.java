package net.metrosystems.demo.pageobjects.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.metrosystems.demo.utils.DriverInit;
import net.metrosystems.demo.utils.SeleniumWrappers;

public class ProductPage extends SeleniumWrappers {
	
	public ProductPage(WebDriver driver) {
		DriverInit.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-to-cart-button")
	public WebElement addToCartBtn;

}
