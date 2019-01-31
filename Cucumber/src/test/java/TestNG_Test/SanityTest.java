package TestNG_Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultPage;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class SanityTest {
	
	WebDriver driver;
	HomePage homepage;
	ProductPage productpage;
	SearchResultPage searchpage;
	CartPage cartpage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	
	@BeforeMethod
	public void setup() {
		System.out.println("setup executed");
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get("https://www.acehardware.com");
		
	}
	
	@AfterMethod
	public void teardown() {
		System.out.println("teardown executed");
		driver.close();
		driver.quit();
		
	}
	
	@Test
	public void tc04() {
		
		System.out.println("entered test4");
		pageObjectManager = new PageObjectManager(driver);
		homepage = pageObjectManager.getHomePage();
		homepage.setsearchfieldtxt("8925497");
		homepage.clickSearchbtn();
		searchpage = pageObjectManager.getSearchResultPage();
		searchpage.clickproduct();
		System.out.println("finished test4");
	}

}
