package net.metrosystems.demo.tests;

import net.metrosystems.demo.pageobjects.emag.EmagPage;
import net.metrosystems.demo.utils.DriverInit;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EmagAssertTest extends DriverInit {
	WebDriverWait wait;
	EmagPage objEmagPage;

	@Test(priority = 1)
	public void verifyEmagHomePage() {
		objEmagPage = new EmagPage(driver);
		objEmagPage.navigateToEmagHomePage();
		assertEquals(driver.getTitle(), "Revolutia Preturilor iunie 2020: Electrocasnice mari & Climatizare");
	}

	@Test(priority = 2)
	public void viewProduct() {		
		objEmagPage.waitUntilElement(objEmagPage.homePageBtn);
		objEmagPage.homePageBtn.click();
	
		objEmagPage.waitUntilElement(objEmagPage.searchBtn);
		objEmagPage.searchBar.click();
		objEmagPage.searchBar.sendKeys("tablou");
		objEmagPage.searchBtn.click();
		
		objEmagPage.waitUntilElements(objEmagPage.productCards);

		assertEquals(true, objEmagPage.productCards.get(3).isDisplayed());
		objEmagPage.productCards.get(3).click();
	}

	@Test(priority = 3)
	public void verifyCustomerOpinion() {
		objEmagPage.waitUntilElement(objEmagPage.addToCart);			
		assertEquals(true, objEmagPage.customerOpinion.isDisplayed());
	}

	@Test(priority = 4)
	public void verifyDiscount() {
		assertEquals(true, objEmagPage.discount.isDisplayed());
	}

	@Test(priority = 5)
	public void verifyPrice() {
		assertEquals(true, objEmagPage.price.isDisplayed());
	}

	@Test(priority = 6)
	public void verifyAddToCartBtn() {
		assertEquals(true, objEmagPage.addToCart.isDisplayed());
	}

	@Test(priority = 7)
	public void verifyAddToFavoritesBtn() {
		assertEquals(true, objEmagPage.addToFavorites.isDisplayed());
	}

	@Test(priority = 8)
	public void addToFavorite() {		
		objEmagPage.addToFavorites.click();
		
		objEmagPage.waitUntilElement(objEmagPage.addedToFavorites);	
		objEmagPage.favoriteBtn.click();

		objEmagPage.waitUntilElement(objEmagPage.favoriteItem);	
		assertEquals(true, objEmagPage.favoriteItem.isDisplayed());
	}

}

//new class open emag, logheaza user, navigheaza homepage
//new method - @test - logheaza user with assert
//new method - @test - navigate homepage - assert driver.getitle()
//cauta dupa tablou - @test - click pe al 4lea element gasit ( div[class="card"] identific elemente) - driver.findelements - accesez dupa index - array
//new method - validateProductPage - verific contine elemente:  opinie clienti, rdeucere, pret, add to cart, adauga favorite
//new method @test - adauga la favorite, navigheaza in favorite ie veriifca ca exista
