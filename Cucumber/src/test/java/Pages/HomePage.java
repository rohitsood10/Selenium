package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Paths;

public class HomePage {
	WebDriver driver;
	@FindBy(css=Paths.homepage_searchfield) private WebElement homepage_searchfield;
	@FindBy(css=Paths.homepage_searchbutton) private WebElement homepage_searchbutton;
	
		
	//constructor for the class
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//enter product id in search field
	public  void setsearchfieldtxt(String Productid) {
		homepage_searchfield.sendKeys(Productid);
		
	}
	
	//enter product id in search field
		public  void clickSearchbtn() {
			homepage_searchbutton.click();
			
		}
		
	//enter product id in search field
		public  void SearchProduct(String ProductID) {
			homepage_searchfield.sendKeys(ProductID);
			homepage_searchbutton.click();
					
		}
	
	

}
