package net.metrosystems.demo.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import net.metrosystems.demo.utils.DriverInit;

public class SmokeTest extends DriverInit {
	WebDriverWait wait;
	WebElement searchBar;
	WebElement searchBtn;
	WebElement productAltImg;
	WebElement productPrice;
	WebElement productImagePreview;
	WebElement productTitle;
	WebElement productAddToCart;

	// Amazon variables
	String URLAmazon = "http://www.amazon.com";
	String amazonSearchBarStr = "twotabsearchtextbox";
	String amazonSearchBtnStr = ".nav-input";
	String amazonProductPriceStr = "priceblock_ourprice";
	String amazonProductImagePreviewStr = "landingImage";
	String amazonProductTitleStr = "productTitle";
	String amazonProductAddToCartStr = "add-to-cart-button";

	// Emag variables
	String URLEmag = "http://www.emag.ro";
	String emagSearchBarStr = "searchboxTrigger";
	String emagSearchBtnStr = ".btn.btn-default.searchbox-submit-button";
	String emagProductPriceStr = ".product-highlight.product-page-pricing .product-new-price";
	String emagProductImagePreviewStr = "img[alt='Masinuta Mattel Hot Wheels Toy Story4 Bo Peep Pony-up']";
	String emagProductTitleStr = ".page-title";
	String emagProductAddToCartStr = ".btn.btn-primary.btn-emag.btn-block.yeahIWantThisProduct.btn-xl.gtm_680klw";

	// Elefant variables
	String URLElefant = "http://www.elefant.ro";
	String elefantSearchBarStr = ".form-control.searchTerm.js-has-overlay";
	String elefantSearchBtnStr = ".btn-search.btn.btn-primary";
	String elefantProductPriceStr = ".pdp-table-th.price-container-pdp .current-price.sale-price";
	String elefantProductImagePreviewStr = "slide-image-0";
	String elefantProductTitleStr = ".product-info .product-brand";
	String elefantProductAddToCartStr = ".add-to-cart .btn.btn-lg.btn-block.btn-primary";

	@Test
	public void testAmazon() {
		driver.get(URLAmazon);

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(amazonSearchBtnStr)));
		searchBar = driver.findElement(By.id(amazonSearchBarStr));
		searchBar.sendKeys("pony toy");
		searchBtn = driver.findElement(By.cssSelector(amazonSearchBtnStr));
		searchBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("img[alt='Tara Toys My Little Pony Necklace Activity Set']")));
		productAltImg = driver.findElement(By.cssSelector("img[alt='Tara Toys My Little Pony Necklace Activity Set']"));
		productAltImg.click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(amazonProductPriceStr)));
		productPrice = driver.findElement(By.id(amazonProductPriceStr));
		productImagePreview = driver.findElement(By.id(amazonProductImagePreviewStr));
		productTitle = driver.findElement(By.id(amazonProductTitleStr));
		productAddToCart = driver.findElement(By.id(amazonProductAddToCartStr));
		assertTrue(productPrice.isDisplayed());

	}

	@Test
	public void testEmag() {
		driver.get(URLEmag);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(emagSearchBtnStr)));
		searchBar = driver.findElement(By.id(emagSearchBarStr));
		searchBar.sendKeys("pony toy");
		searchBtn = driver.findElement(By.cssSelector(emagSearchBtnStr));
		searchBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("img[alt='Masinuta Mattel Hot Wheels Toy Story4 Bo Peep Pony-up']")));
		productAltImg = driver
				.findElement(By.cssSelector("img[alt='Masinuta Mattel Hot Wheels Toy Story4 Bo Peep Pony-up']"));
		productAltImg.click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(emagProductPriceStr)));
		productPrice = driver.findElement(By.cssSelector(emagProductPriceStr));
		productImagePreview = driver.findElement(By.cssSelector(emagProductImagePreviewStr));
		productTitle = driver.findElement(By.cssSelector(emagProductTitleStr));
		productAddToCart = driver.findElement(By.cssSelector(emagProductAddToCartStr));
		assertTrue(productPrice.isDisplayed());

	}

	@Test
	public void testElefant() throws InterruptedException {
		driver.get(URLElefant);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elefantSearchBarStr)));
		searchBar = driver.findElement(By.cssSelector(elefantSearchBarStr));	
		searchBar.sendKeys("pony");			
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elefantSearchBtnStr)));
		searchBtn = driver.findElement(By.cssSelector(elefantSearchBtnStr));
		searchBtn.click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"img[alt='Set Caiet colorat si 5 creioane cerate My Little Pony fotografia produsului']")));	
		Thread.sleep(2000);
		productAltImg = driver.findElement(By
				.cssSelector("img[alt='Set Caiet colorat si 5 creioane cerate My Little Pony fotografia produsului']"));
		productAltImg.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elefantProductPriceStr)));
		productPrice = driver.findElement(By.cssSelector(elefantProductPriceStr));
		productImagePreview = driver.findElement(By.id(elefantProductImagePreviewStr));
		productTitle = driver.findElement(By.cssSelector(elefantProductTitleStr));
		productAddToCart = driver.findElement(By.cssSelector(elefantProductAddToCartStr));
		assertTrue(productPrice.isDisplayed());
	}

	@AfterMethod
	public void printObjects() {
		System.out.println("Product price element is displayed: " + productPrice);
		System.out.println("Product image element is displayed: " + productImagePreview);
		System.out.println("Product title element is displayed: " + productTitle);
		System.out.println("Add to cart element is displayed: " + productAddToCart);
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}

//alta clasa de test smoke test
//3 metode, fiecare metoda deschide: 1 deschide amazon si navigheaza p o pagina de produs; 2 deschide emag si navigheaza pe o pagina de produs; 3 deschide elefant si navigheaza pe produs
//se scot elementele comune din paginile de produs (5 elemente comune) si se verifica pe fiecare pagina ca exista
//o lista cu cele 5 elemente, verificarea fiecarui element sa printeze in console: elementul X a fost gasit 
//adnotari before after

//https://the-internet.herokuapp.com/javascript_alerts
//clasa noua 
// 