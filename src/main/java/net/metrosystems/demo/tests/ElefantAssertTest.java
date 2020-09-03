package net.metrosystems.demo.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import net.metrosystems.demo.utils.DriverInit;

public class ElefantAssertTest extends DriverInit {
	WebDriverWait wait;
	WebElement searchBar;
	WebElement searchBtn;
	WebElement jucariiCopiiBebeChkBox;
	WebElement jucariiCopiiBebeTitle;
	WebElement dismissCookieMessage;
	WebElement fiftyToOneHundredChkBox;
	WebElement quantityFromLeftPane;
	WebElement quantityFromSubTitle;
	WebElement firstProduct;
	WebElement adaugaInCosBtn;
	WebElement productPriceFull;
	WebElement vizualizareCosBtn;
	WebElement comandaBtn;
	WebElement cresteCantitate;
	WebElement totalPriceFull;

	String amazonWebsiteStr = "http://www.elefant.ro";
	String productStr = "lego";
	String searchBarStr = ".form-control.searchTerm.js-has-overlay";
	String searchBtnStr = ".btn-search.btn.btn-primary";
	String jucariiCopiiBebeStr = "//ul[@id='CategoryUUIDLevelMulti_id']//a[text()='Jucarii, Copii & Bebe']";
	String jucariiCopiiBebeTitleStr = "//h1[contains(text(), 'lego -')]";
	String dismissCookieMessageStr = ".cc-btn.cc-dismiss";
	String fiftyToOneHundredStr = "//div[contains(@class, 'filter-group')]//a[text()='50 - 100']";
	String quantityFromLeftPaneStr = "//div[@id='filter-accordion']/div[4]/ul[1]/li/span";
	String quantityFromSubTitleStr = "//div[@id='SortingRow']/div[2]/div";
	// String firstProductStr = "#product-search-result .col-xs-12
	// .search-product-list .product-list.row div:nth-child(1) .product-tile
	// .product-image-container";
	// PUR SI SIMPLU NU MERGE CU ASTA ^
	String firstProductStr = "//*[@id='product-search-result']/div[2]/div[5]/div[1]/div[1]/div/div[2]/a[3]";
	String adaugaInCosStr = ".add-to-cart .btn.btn-lg.btn-block.btn-primary";
	int productPriceInt;
	String productPriceStr = ".pdp-table-th.price-container-pdp .current-price.sale-price";
	String vizualizareCosStr = ".view-cart  .btn.btn-primary.btn-lg.btn-block";
	String comandaStr = ".cost-summary .btn.btn-lg.btn-block.btn-primary";
	String cresteCantitateStr = ".btn-number.js-detail-productQuantity-increase";
	String totalPriceStr = ".price .total-price";
	int productPriceIntx3;

	@Test(priority = 0)
	public void navigateToAmazon() {
		driver.get(amazonWebsiteStr);
		assertEquals(driver.getTitle(),
				"elefant.ro - mallul online al familiei tale! • Branduri de top, preturi excelente • Peste 500.000 de produse pentru tine!");
	}

	@Test(priority = 1)
	public void searchProduct() throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(searchBarStr)));
		searchBar = driver.findElement(By.cssSelector(searchBarStr));
		searchBar.click();
		Thread.sleep(2000);
		searchBar.sendKeys("lego");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(searchBtnStr)));
		searchBtn = driver.findElement(By.cssSelector(searchBtnStr));
		searchBtn.click();

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jucariiCopiiBebeStr)));
		jucariiCopiiBebeChkBox = driver.findElement(By.xpath(jucariiCopiiBebeStr));
		assertEquals(true, jucariiCopiiBebeChkBox.isDisplayed());
	}

	@Test(priority = 2)
	public void filterByJucariiCopiiBebe() throws InterruptedException {
		jucariiCopiiBebeChkBox = driver.findElement(By.xpath(jucariiCopiiBebeStr));
		jucariiCopiiBebeChkBox.click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jucariiCopiiBebeTitleStr)));
		jucariiCopiiBebeTitle = driver.findElement(By.xpath(jucariiCopiiBebeStr));
		assertEquals(true, jucariiCopiiBebeTitle.isDisplayed());
	}

	@Test(priority = 4)
	public void filterByFiftyToOneHundred() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(dismissCookieMessageStr)));
		dismissCookieMessage = driver.findElement(By.cssSelector(dismissCookieMessageStr));
		dismissCookieMessage.click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fiftyToOneHundredStr)));
		fiftyToOneHundredChkBox = driver.findElement(By.xpath(fiftyToOneHundredStr));
		fiftyToOneHundredChkBox.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jucariiCopiiBebeTitleStr)));
		jucariiCopiiBebeTitle = driver.findElement(By.xpath(jucariiCopiiBebeStr));
		assertEquals(true, jucariiCopiiBebeTitle.isDisplayed());
	}

	@Test(priority = 5)
	public void compareAvailableProductsQuantity() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityFromLeftPaneStr)));
		quantityFromLeftPane = driver.findElement(By.xpath(quantityFromLeftPaneStr));
		String quantityLeftPane = quantityFromLeftPane.getText().replace("(", "").replace(")", "");
		System.out.println(quantityLeftPane);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(quantityFromSubTitleStr)));
		quantityFromSubTitle = driver.findElement(By.xpath(quantityFromSubTitleStr));
		String quantitySubTitle = quantityFromSubTitle.getText().replace(" produse", "");
		System.out.println(quantitySubTitle);

		assertEquals(quantityLeftPane, quantitySubTitle);
	}

	@Test(priority = 6)
	public void clickFirstProduct() {
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(firstProductStr)));
		firstProduct = driver.findElement(By.xpath(firstProductStr));
		firstProduct.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(adaugaInCosStr)));
		adaugaInCosBtn = driver.findElement(By.cssSelector(adaugaInCosStr));
		assertEquals(true, adaugaInCosBtn.isDisplayed());
	}

	@Test(priority = 7)
	public void getProductPrice() {		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(productPriceStr)));
		productPriceFull = driver.findElement(By.cssSelector(productPriceStr));
		String productPrice = productPriceFull.getText().replace(" lei", "").replace(",", "").trim();
		productPriceInt = Integer.parseInt(productPrice);
		System.out.println("Product price one piece: " + productPriceInt);
		assertTrue(productPriceFull.isDisplayed());
	}

	@Test(priority = 8)
	public void addProductToCart() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(adaugaInCosStr)));
		adaugaInCosBtn.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(vizualizareCosStr)));
		vizualizareCosBtn = driver.findElement(By.cssSelector(vizualizareCosStr));
		assertEquals(true, vizualizareCosBtn.isDisplayed());
	}

	@Test(priority = 9)
	public void viewCart() {
		vizualizareCosBtn.click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(comandaStr)));
		comandaBtn = driver.findElement(By.cssSelector(comandaStr));
		assertEquals(true, comandaBtn.isDisplayed());
	}

	@Test(priority = 10)
	public void assertTotalPrice() {	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cresteCantitateStr)));
		cresteCantitate = driver.findElement(By.cssSelector(cresteCantitateStr));
		cresteCantitate.click();
		cresteCantitate.click();
		totalPriceFull = driver.findElement(By.cssSelector(totalPriceStr));
		String totalPrice = totalPriceFull.getText().replace(" lei", "").replace(",", "");
		int totalPriceInt = Integer.parseInt(totalPrice);
		System.out.println("Total price 3 pieces: " + totalPriceInt);		
		productPriceIntx3 = productPriceInt * 3;
		
		assertEquals(totalPriceInt, productPriceIntx3);	
	}

}

//clasa test end to end
//navigatetoAmazon
//cauti dupa lego 
//filtrez dupa: Jucarii copii si bebe
//filtrez dupa: 50-100
//compari <span class="filter-count">(100)</span> cu <div class="hidden-sm element-count text-nowrap">100 produse</div>
//iau pret 
//adaug in cos
//cantite x3 
//assert pret initial cu cantitate x3
