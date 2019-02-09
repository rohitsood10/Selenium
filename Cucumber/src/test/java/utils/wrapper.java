package utils;

import org.openqa.selenium.WebElement;

public class wrapper {
	
	public static void btn_click(WebElement Element) {
		Element.click();
		System.out.println("Clicked from wrapper class");
	}

}
