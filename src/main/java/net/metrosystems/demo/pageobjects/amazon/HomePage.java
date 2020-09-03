package net.metrosystems.demo.pageobjects.amazon;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.metrosystems.demo.utils.PropertiesLoad;
import net.metrosystems.demo.utils.SeleniumWrappers;

public class HomePage extends SeleniumWrappers{
	public static String homepageURL = PropertiesLoad.config.getProperty("url");
	
	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchBar;
	
	@FindBy(className = "nav-input")
	public WebElement searchBtn;

	public void navigateToHomePage() {
		driver.get(homepageURL);		
	}
	
	public void searchProduct(String product) {
		sendKeys(searchBar, product);
		click(searchBtn);
	}

	
	
}


