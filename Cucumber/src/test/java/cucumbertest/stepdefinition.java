package cucumbertest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class stepdefinition {
	
WebDriver driver;
HomePage homepage;
ProductPage productpage;
SearchResultPage searchpage;
CartPage cartpage;
PageObjectManager pageObjectManager;
WebDriverManager webDriverManager;

@Given("^user is on the home page$")
public void user_is_on_the_home_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	/*String path = "C:\\SeleniumProjects\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", path);
	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.manage().window().maximize();
	driver.get("https://www.acehardware.com");*/
	webDriverManager = new WebDriverManager();
	driver = webDriverManager.getDriver();
	driver.get("https://www.acehardware.com");
	System.out.println("setup function: opened url");
	pageObjectManager = new PageObjectManager(driver);
}

@When("^user searches for product \"([^\"]*)\"$")
public void user_searches_for_product(String productid) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	//homepage.SearchProduct("8925497");
	//homepage.setsearchfieldtxt(8925497)
	homepage = pageObjectManager.getHomePage();
	homepage.setsearchfieldtxt(productid);
	homepage.clickSearchbtn();
	
}

@When("^user selects the product$")
public void user_selects_the_product() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	searchpage = pageObjectManager.getSearchResultPage();
	searchpage.clickproduct();
}

@When("^user clicks on add to cart button$")
public void user_clicks_on_add_to_cart_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	productpage = pageObjectManager.getProductPage();
	Thread.sleep(5000);
	productpage.addtocartbtn();
	
}

@When("^user clicks on View cart&checkout button$")
public void user_clicks_on_View_cart_checkout_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	productpage.checkoutbtn();
}

@When("^user select prefered shipping method as ship to home$")
public void user_select_prefered_shipping_method_as_ship_to_home() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	cartpage = pageObjectManager.getcartpage();
	Thread.sleep(5000);
	//cartpage.selectshiptohome();
	cartpage.clickcheckoutbtn();
}

@When("^user clicks on checkout as guest button$")
public void user_clicks_on_checkout_as_guest_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Step7");
}

@When("^user fills personal details and clicks continue$")
public void user_fills_personal_details_and_clicks_continue() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Step8");
}

@Then("^user reaches on shipping page$")
public void user_reaches_on_shipping_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Step9");
}


}
