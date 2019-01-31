package cucumber;

import managers.PageObjectManager;
import managers.WebDriverManager;
 
public class TestContext {
 private WebDriverManager webDriverManager;
 private PageObjectManager pageObjectManager;
 int a=2;
		 
 public TestContext(){
 webDriverManager = new WebDriverManager();
 pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
 }
 
 public WebDriverManager getWebDriverManager() {
 return webDriverManager;
 }
 
 public PageObjectManager getPageObjectManager() {
 return pageObjectManager;
 }
 
}