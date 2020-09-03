package net.metrosystems.demo.pageobjects.emag;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmagPage {
	final WebDriver driver;
	WebDriverWait wait;
	String urlEmag = "https://emag.ro";
	
	@FindBy(css = "img[alt='eMAG']") 
	public WebElement homePageBtn; 

	@FindBy(id = "searchboxTrigger")
	public WebElement searchBar;

	@FindBy(css = ".btn.btn-default.searchbox-submit-button")
	public WebElement searchBtn;

	@FindBy(css = "div[class='card']")
	public List<WebElement> productCards;

	@FindBy(css = ".product-highlight p.text-label")
	public WebElement customerOpinion;

	@FindBy(css = ".product-highlight.product-page-pricing .product-old-price")
	public WebElement discount;

	@FindBy(css = ".product-highlight.product-page-pricing .product-new-price")
	public WebElement price;

	@FindBy(css = ".btn.btn-primary.btn-emag.btn-block.yeahIWantThisProduct.btn-xl.gtm_680klw")
	public WebElement addToCart;

	@FindBy(css = ".add-to-favorites.btn.btn-xl.btn-default.btn-icon.btn-block.gtm_t95ovv")
	public WebElement addToFavorites;

	@FindBy(css = ".add-to-favorites.btn.btn-xl.btn-default.btn-icon.btn-block.gtm_t95ovv.add-to-favorites-active")
	public WebElement addedToFavorites;

	@FindBy(id = "my_wishlist")
	public WebElement favoriteBtn;

	@FindBy(css = ".d-flex .card-image.flex-item.flex-c")
	public WebElement favoriteItem;

	public EmagPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitUntilElement(WebElement locator) { 
		wait = new WebDriverWait(driver, 10);		
		wait.until(ExpectedConditions.visibilityOf(locator));		
	}
	
	public void waitUntilElements(List<WebElement> locator) {
		wait = new WebDriverWait(driver, 10);		
		wait.until(ExpectedConditions.visibilityOfAllElements(locator));
	}
	
	public void navigateToEmagHomePage() {
		driver.get(urlEmag);		
	}

}

