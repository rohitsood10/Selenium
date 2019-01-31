package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Paths;

public class CartPage {
	WebDriver drive;
	@FindBy(xpath=Paths.cartpage_shiptohomebtn) private WebElement cartpage_shiptohomebtn;
	@FindBy(xpath=Paths.cartpage_checkoutbtn) private WebElement cartpage_checkoutbtn;
 
	public CartPage(WebDriver driver) {
		this.drive=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public void selectshiptohome() throws InterruptedException {
		try {
			Thread.sleep(5000);
			boolean bValue = false;
			bValue= cartpage_shiptohomebtn.isEnabled();
			if (bValue=true) {
				System.out.println("Ship to home is displayed");
			}else {
				System.out.println("Ship to home is not displayed");
				
			}
			
/*			if(cartpage_shiptohomebtn.isEnabled())
				System.out.println("Ship to home is displayed");

			if(cartpage_shiptohomebtn.isSelected())
				System.out.println("Ship to home is selected"); */
			
			cartpage_shiptohomebtn.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			Thread.sleep(5000);
			cartpage_shiptohomebtn.click();		}
		
	}
	
	public void clickcheckoutbtn() throws InterruptedException {
		try {
			cartpage_checkoutbtn.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			Thread.sleep(5000);
			cartpage_checkoutbtn.click();		}
		
	}

}
