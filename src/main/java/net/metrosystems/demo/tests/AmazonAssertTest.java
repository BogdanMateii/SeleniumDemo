package net.metrosystems.demo.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import net.metrosystems.demo.utils.DriverInit;

public class AmazonAssertTest extends DriverInit {
	String amazonWebsiteStr = "http://www.amazon.com";

	WebDriverWait wait;
	WebElement searchBar;
	WebElement searchBtn;
	WebElement quantityDropdown;
	Select quantity;
	WebElement addToCart;
	WebElement ponyPriceWithDollar;
	WebElement priceFromCartWithDollar;
	WebElement proceedToCheckoutBtn;
	WebElement continueBtn;

	String searchBarStr = "twotabsearchtextbox";
	String searchBtnStr = "nav-input";
	String ponyStr = "My Little Pony Toy Oh My Giggles Pinkie Pie -- 8\" Interactive Toy with Sounds & Movement, Kids Ages 3 Years Old & Up";
	String quantityStr = "quantity";
	String addToCartStr = "add-to-cart-button";
	String ponyPriceStr = "priceblock_ourprice";
	String totalPriceStr = "span.a-color-price.hlb-price.a-inline-block.a-text-bold";
	double quantityMultiplyPriceDbl;
	double priceFromCartDbl;
	String proceedToCheckoutStr = "hlb-ptc-btn-native";
	String continueStr = "continue";

	@Test
	public void amazonTest() throws InterruptedException {
		driver.get("http://www.amazon.com");		
		Thread.sleep(1000);
		String amazonTitleStr = driver.getTitle();
		System.out.println(amazonTitleStr);
		assertEquals(amazonTitleStr,
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",
				"Amazon title is NOT correct");
		searchBar = driver.findElement(By.id(searchBarStr));
		searchBar.sendKeys(ponyStr);
		searchBtn = driver.findElement(By.className(searchBtnStr));
		searchBtn.click();
		clickPony();
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(quantityStr)));
		String ponyTitleStr = driver.getTitle();
		assertEquals(ponyTitleStr,
				"Amazon.com: My Little Pony Toy Oh My Giggles Pinkie Pie -- 8\" Interactive Toy with Sounds & Movement, Kids Ages 3 Years Old & Up: Toys & Games",
				"Pony title is NOT correct");
		Boolean verifyPonyTitle = ponyTitleStr.equals(
				"Amazon.com: My Little Pony Toy Oh My Giggles Pinkie Pie -- 8\" Interactive Toy with Sounds & Movement, Kids Ages 3 Years Old & Up: Toys & Games");

		if (verifyPonyTitle) {
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ponyPriceStr)));

			ponyPriceWithDollar = driver.findElement(By.id(ponyPriceStr));
			
			String ponyPriceStr = ponyPriceWithDollar.getText().replace("$", "");
			double ponyPriceDbl = Double.valueOf(ponyPriceStr);
			System.out.println("One piece price of pony is: " + ponyPriceDbl);

			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(quantityStr)));
			quantityDropdown = driver.findElement(By.id(quantityStr));
			quantity = new Select(quantityDropdown);
			quantity.selectByValue("2");
			quantityDropdown = quantity.getFirstSelectedOption();			
			String quantityStr = quantityDropdown.getText();
			int quantityInt = Integer.parseInt(quantityStr.trim()); // value have blank spaces
			System.out.println("quantity is " + quantityInt);

			quantityMultiplyPriceDbl = (double) (quantityInt * ponyPriceDbl);
			System.out.println("Product x Quantity price is: " + quantityMultiplyPriceDbl);

			addToCart = driver.findElement(By.id(addToCartStr));
			addToCart.click();
			verifyTotalPrice();

			proceedToCheckoutBtn = driver.findElement(By.id(proceedToCheckoutStr));
			proceedToCheckoutBtn.click();
			verifyProceedToCheckoutPageOpen();

		} else {
			driver.quit();
		}

	}

	public void clickPony() {
		WebElement pony = driver.findElement(By.cssSelector("img[alt='" + ponyStr + "']"));
		pony.click();
	}

	@Test
	public void verifyTotalPrice() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(totalPriceStr)));

		String addToCartTitleStr = driver.getTitle();
		
		//assertequals with bool instead of 114-116
		assertEquals(addToCartTitleStr, "Amazon.com Shopping Cart", "Add to cart title not correct");
		Boolean verifyAddToCartTitle = addToCartTitleStr.equals("Amazon.com Shopping Cart");
		if (verifyAddToCartTitle) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(totalPriceStr)));
			priceFromCartWithDollar = driver.findElement(By.cssSelector(totalPriceStr));
			String totalPriceStr = priceFromCartWithDollar.getText().replace("$", "");
			priceFromCartDbl = Double.valueOf(totalPriceStr);
			System.out.println("Total price from cart is: " + priceFromCartDbl);
			assertEquals(quantityMultiplyPriceDbl, priceFromCartDbl,
					"Values not the same, expected " + priceFromCartDbl + "but found " + quantityMultiplyPriceDbl);
		}
	}

	@Test
	public void verifyProceedToCheckoutPageOpen() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(continueStr)));
		assertEquals(continueStr, "continue", "Continue button not available"); // verifica buton
		assertEquals(driver.getTitle(), "Amazon Sign-In", "Title not correct");
	}

}

//New class
//open amazon
//cauta dupa pony
//assert la page title 
//create method - care da click pe My Little Pony Toy Oh My Giggles Pinkie Pie -- 8" Interactive Toy with Sounds & Movement, Kids Ages 3 Years Old & Up
//assert pe page title  - pagina care trebuie. daca assert pass - scot pret, else driver.quit
//scot quantity, doi. add to cart
//o metoda noua care verifica titul paginii, assert Added to Cart, verifica pretul corect (assert equals(pret x cantintate, pret final))
//Proceed to checkout, o metoda noua, assert Sign-In string, assert titlu pagina


