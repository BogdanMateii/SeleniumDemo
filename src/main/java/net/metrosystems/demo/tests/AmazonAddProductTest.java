package net.metrosystems.demo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import net.metrosystems.demo.utils.DriverInit;

public class AmazonAddProductTest extends DriverInit {
	String amazonWebsite = "http://www.amazon.com";

	WebDriverWait wait;
	WebElement searchBar;
	WebElement searchBtn;
	WebElement quantityDropdown;
	Select quantity;
	WebElement addToCart;

	String searchBarStr = "twotabsearchtextbox";
	String searchBtnStr = "nav-input";
	String michaelKorsWatchStr = "Michael Kors Women's Blair Chronograph Stainless Steel Watch";
	String skagenWatchStr = "Skagen Mens Signatur Slim Titanium Case - SKW6484";
	String timexWatchStr = "Timex Ironman Classic 30 Full-Size 38mm Watch";
	String totalPriceStr = "span.a-color-price.hlb-price.a-inline-block.a-text-bold";
	String quantityStr = "quantity";
	String addToCartStr = "add-to-cart-button";

	@Test
	public void amazonTest() throws InterruptedException {
		driver.get(amazonWebsite);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(searchBarStr))).click();
		searchBar = driver.findElement(By.id(searchBarStr));
		searchBar.click();
		searchBar.sendKeys(michaelKorsWatchStr);
		searchBtn = driver.findElement(By.className(searchBtnStr));
		searchBtn.click();
		WebElement michaelKorsWatch = driver
				.findElement(By.cssSelector("img[alt='" + michaelKorsWatchStr + "']"));
		michaelKorsWatch.click();
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(quantityStr)));
		WebElement quantityDropdown = driver.findElement(By.id(quantityStr));
		quantity = new Select(quantityDropdown);
		quantity.selectByIndex(0); // dupa index
		WebElement michaelKorsPrice = driver.findElement(By.id("priceblock_ourprice"));
		String michaelKorsPriceString = michaelKorsPrice.getText();
		addToCart = driver.findElement(By.id(addToCartStr));
		addToCart.click();

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(searchBarStr))).click();
		searchBar = driver.findElement(By.id(searchBarStr));
		searchBar.click();
		searchBar.sendKeys(skagenWatchStr);
		searchBtn = driver.findElement(By.className(searchBtnStr));
		searchBtn.click();
		WebElement skagenWatch = driver.findElement(By
				.cssSelector("img[alt='" + skagenWatchStr + "']"));
		skagenWatch.click();
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(quantityStr)));
		quantityDropdown = driver.findElement(By.id(quantityStr));
		quantity = new Select(quantityDropdown);
		quantity.selectByVisibleText("1"); // dupa visible text
		WebElement skagenPrice = driver.findElement(By.id("priceblock_ourprice"));
		String skagenPriceString = skagenPrice.getText();
		addToCart = driver.findElement(By.id(addToCartStr));
		addToCart.click();

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(searchBarStr))).click();
		searchBar = driver.findElement(By.id(searchBarStr));
		searchBar.click();
		searchBar.sendKeys(timexWatchStr);
		searchBtn = driver.findElement(By.className(searchBtnStr));
		searchBtn.click();
		WebElement timexWatch = driver
				.findElement(By.cssSelector("img[alt='" + timexWatchStr + "']"));
		timexWatch.click();
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(quantityStr)));
		quantityDropdown = driver.findElement(By.id(quantityStr));
		quantity = new Select(quantityDropdown);
		quantity.selectByVisibleText("1"); // dupa value nu exista
		WebElement timexPrice = driver.findElement(By.id("priceblock_ourprice"));
		String timexPriceString = timexPrice.getText();
		addToCart = driver.findElement(By.id(addToCartStr));
		addToCart.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(totalPriceStr)));
		WebElement totalPrice = driver.findElement(By.cssSelector(totalPriceStr));
		String totalPriceString = totalPrice.getText();

		String[] watches = new String[4];
		watches[0] = "Michael Kors ";
		watches[1] = "Skagen ";
		watches[2] = "Timex ";
		watches[3] = "Total ";

		for (int i = 0; i < 5; i++) {
			switch (i) {
			case 1:
				System.out.println(watches[0] + "price " + michaelKorsPriceString);
				break;
			case 2:
				System.out.println(watches[1] + "price " + skagenPriceString);
				break;
			case 3:
				System.out.println(watches[2] + "price " + timexPriceString);
				break;
			case 4:
				System.out.println(watches[3] + "price " + totalPriceString); 
				break;
			}
		}


	}

}





//  New class, open amazon.com O list care sa contina 3 stringuri (casio, rolex,
//  timex)
//  Click pe fiecare string in parte
//  Cresc cantitatea la casio dupa index
//  Cresc cantitatea la rolex dupa visibletext
//  Cresc cantitatea la timex dupa
//  value 
//  Adaug pe fiecare in cos, in total: verific pretul conform cu cantitatea
//  produselor
