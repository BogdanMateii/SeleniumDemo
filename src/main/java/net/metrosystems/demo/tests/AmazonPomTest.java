package net.metrosystems.demo.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Base64;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import net.metrosystems.demo.pageobjects.amazon.ProductPage;
import net.metrosystems.demo.pageobjects.amazon.HeaderPage;
import net.metrosystems.demo.pageobjects.amazon.HomePage;
import net.metrosystems.demo.pageobjects.amazon.LoginCaptchaPage;
import net.metrosystems.demo.pageobjects.amazon.LoginPasswordPage;
import net.metrosystems.demo.pageobjects.amazon.LoginUsernamePage;
import net.metrosystems.demo.pageobjects.amazon.SearchResultPage;
import net.metrosystems.demo.utils.DriverInit;
import net.metrosystems.demo.utils.PropertiesLoad;
import net.metrosystems.demo.utils.SeleniumWrappers;

@Listeners(net.metrosystems.demo.utils.TestNGListener.class)
public class AmazonPomTest extends SeleniumWrappers {
	HeaderPage headerPage;
	HomePage homePage;
	LoginUsernamePage loginUsernamePage;
	LoginPasswordPage loginPasswordPage;
	LoginCaptchaPage loginCaptchaPage;
	SearchResultPage searchResultsPage;
	ProductPage productPage;	

	@BeforeClass
	public void before() throws InterruptedException {
		driver = DriverInit.setDriverPath();
	}

	@Test(priority = 0)
	public void navigateHomePage() {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.navigateToHomePage();
		assertEquals(homePage.getCurrentTitle(),
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}

	@Test(priority = 1)
	public void verifyLoginSuccessful() {
		headerPage = PageFactory.initElements(driver, HeaderPage.class);
		click(headerPage.signInBtn);
		loginUsernamePage = PageFactory.initElements(driver, LoginUsernamePage.class);
		assertEquals(true, loginUsernamePage.emailInput.isDisplayed());
	}

	@Test(priority = 2)
	public void insertUsername() {		
		sendKeys(loginUsernamePage.emailInput, SeleniumWrappers.decodedStringPropertiesFile("loginEmail"));
		click(loginUsernamePage.continueBtn);
		loginPasswordPage = PageFactory.initElements(driver, LoginPasswordPage.class);
		assertEquals(true, loginPasswordPage.passwordInput.isDisplayed());
	}

	/*
	 * @Test(priority = 3) public void insertPassword() {
	 * sendKeys(loginPasswordPage.passwordInput,
	 * SeleniumWrappers.decodedStringPropertiesFile("loginPass2"));
	 * click(loginPasswordPage.signInBtn); loginCaptchaPage =
	 * PageFactory.initElements(driver, LoginCaptchaPage.class); assertEquals(true,
	 * loginCaptchaPage.captcha.isDisplayed()); }
	 */

	@Test(priority = 4)
	public void verifyProductPage() throws InterruptedException, IOException {
		homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.navigateToHomePage();
		homePage.searchProduct("My Little Pony Toys Meet the Mane 6 Ponies Collection (Amazon Exclusive)");

		searchResultsPage = PageFactory.initElements(driver, SearchResultPage.class);
		searchResultsPage.getProductCardIndexElement(1).click();

		productPage = PageFactory.initElements(driver, ProductPage.class);
		Thread.sleep(2000);
		assertEquals(true, productPage.addToCartBtn.isDisplayed());
	}

}

//pachet java de utilitare (e.g. clasa cu driver instaintiere (setDriverPath),  + clasa de screnenshot, clasa SeleniumWrappers (click, sendkeys,) )
//pachet de pages amazon (login page, home page, product page, cart page)
//testul se logheaza, cauta dupa pony, search producs (o metoda care ia findelements - primesti ca parametru index ), alta metoda care da click pe element dupa indicator unic, poza pe search results, pe product page
//click(obj)
//username, url, browser based on parameter - fisier de tip .properties (fileUtils)
//configurez test.ng xml (3 fisiere), unu ruelaza topata clasa, celelalte 2 grupuri de cate 3
//groups din test ng, 3 in prima grupa 3 in a 2-a grupa. 
// https://testng.org/doc/documentation-main.html#running-testng


//jenkins http://10.97.178.217:9091/login?from=%2F bogdan/metro123
// adaug in pom.xml surefire plugin

