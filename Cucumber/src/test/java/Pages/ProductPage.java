package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Paths;

public class ProductPage {
	WebDriver driver;
	@FindBy(xpath=Paths.productpage_qtyfield) private WebElement productpage_qtyfield;
	@FindBy(xpath=Paths.productpage_addtocartbtn) private WebElement productpage_addtocartbtn;
	@FindBy(xpath=Paths.productpage_viewcart_checkoutbtn) private WebElement productpage_viewcart_checkoutbtn;
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void addtocartbtn() {
			productpage_addtocartbtn.click();
		
	}
	
	public void checkoutbtn() throws InterruptedException {
		try {
			productpage_viewcart_checkoutbtn.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			Thread.sleep(5000);
			productpage_viewcart_checkoutbtn.click();
		}
		
		
	}
	
	

}