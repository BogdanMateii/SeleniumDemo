import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
	
	@Test
	public void bbeb() {

		System.setProperty("webdriver.chrome.driver","C:\\APPS\\eclipse-workspace\\chromedriver\\chromedriver.exe");
		
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);


		
		WebDriver driver = new ChromeDriver(options);

		driver.get("http://www.facebook.com");
		System.out.println(driver.getTitle());
		driver.quit();
		}

}
