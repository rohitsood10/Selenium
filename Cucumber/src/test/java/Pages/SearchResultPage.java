package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Paths;

public class SearchResultPage {
	
	WebDriver driver;
	@FindBy(xpath=Paths.searchresultpage_selectproduct) private WebElement searchresultpage_selectproduct;

	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickproduct() {
		searchresultpage_selectproduct.click();
				
	}

}
