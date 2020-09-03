package net.metrosystems.demo.tests;

import java.awt.AWTException;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import net.metrosystems.demo.utils.*;

public class WebsitesTest extends DriverInit {

	private String urlEmag = "https://emag.ro";
	private String urlElefant;
	private String urlAmazon;
	private String currentTitle;

	@Test
	public void websiteTestURL() throws InterruptedException, AWTException {
		
		driver.get(urlEmag);
		urlEmag = driver.getCurrentUrl();
		System.out.println(urlEmag);
		driver.getCurrentUrl();
		currentTitle = driver.getTitle();
		if (urlEmag.equals("https://www.emag.ro/")) {
			System.out.println("Current URL is " + urlEmag);
			if (currentTitle.equals("eMAG.ro - Libertate în fiecare zi")) {
				System.out.println("Current title is " + currentTitle);
			} else {
				System.out.println("Current title is NOT " + currentTitle);
				driver.quit();
			}
		} else {
			System.out.println("Current URL is NOT " + urlEmag);
			driver.quit();
		}

		driver.get("https://www.elefant.ro");
		urlElefant = driver.getCurrentUrl();
		Dimension currentSize = new Dimension(640, 480);
		driver.manage().window().setSize(currentSize);
		currentTitle = driver.getTitle();
		if (currentTitle.equals(
				"elefant.ro - mallul online al familiei tale! • Branduri de top, preturi excelente • Peste 500.000 de produse pentru tine!")) {
			System.out.println("Current title is: " + currentTitle);
			if (urlElefant.equals("https://www.elefant.ro/")) {
				System.out.println("Current URL is: " + urlElefant);
				System.out.println(driver.manage().window().getSize());
				if (driver.manage().window().getSize().toString().equals("(640, 480)")) {
					driver.get("http://www.amazon.com");
					urlAmazon = driver.getCurrentUrl();
					driver.manage().window().maximize();
					int pageHeight = driver.manage().window().getSize().getHeight();
					int pageLenght = driver.manage().window().getSize().getWidth();
					System.out.println("Amazon height: " + pageHeight);
					System.out.println("Amazon lenght: " + pageLenght);
					if (!urlAmazon.equals(urlEmag)) {
						System.out.println("Title not emag.ro");
						if (!urlAmazon.equals(urlElefant)) {
							System.out.println("Title not elefant.ro");
							if (!driver.manage().window().getSize().toString().equals("(640, 480)")) {
								if (urlAmazon.equals("https://www.amazon.com/")) { // no driver.get or navigateto()
			
									driver.navigate().back();


								} else {
									System.out.println("Current URL is NOT " + urlAmazon);
									driver.quit();
								}
							}
						}
					}
				}
			} else {
				System.out.println("Current URL is NOT " + urlElefant);
				driver.quit();
			}
		}
	}

}
//REMIND ABOUT GIT
//Ziua de invatare
