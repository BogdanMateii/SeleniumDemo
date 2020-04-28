package net.metrosystems.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebsitesEmagPage {
	final WebDriver driver;

	@FindBy(id = "masthead")
	WebElement header;

	public WebsitesEmagPage(WebDriver driver) {

		this.driver = driver;
	}

}
