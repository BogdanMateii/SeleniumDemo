package net.metrosystems.demo.pageobjects.amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.metrosystems.demo.utils.SeleniumWrappers;

public class SearchResultPage extends SeleniumWrappers {
	@FindBy(css = "img[data-image-index='" + 1 + "']")
	public List<WebElement> productCardsIndex;

	public WebElement getProductCardTitleElement(String title) {
		return driver.findElement(By.cssSelector("img[alt='" + title + "']"));
	}
	
	public WebElement getProductCardIndexElement(int index) {
		return driver.findElement(By.cssSelector("img[data-image-index='" + index + "']"));
	} 

}
