package TestNG_Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultPage;
import listeners.RetryAnalyzer;
import listeners.RetryCountIfFailed;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import utils.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Listeners(listeners.Listener.class)

public class SmokeTest {
	
	WebDriver driver;
	HomePage homepage;
	ProductPage productpage;
	SearchResultPage searchpage;
	CartPage cartpage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;	
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup() {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/SmokeTest.html");
		reporter.loadXMLConfig(FileReaderManager.getInstance().getConfigReader().getReportConfigPath());
		extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    System.out.println("setup executed");
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get("https://www.acehardware.com");
		
	}
	
	
	
	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=Utility.getScreenshot(driver);
			
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		System.out.println("teardown executed");
		extent.flush();
		driver.close();
		driver.quit();
		
	}
	
/*	@Test(retryAnalyzer = RetryAnalyzer.class)
	@RetryCountIfFailed(2)
	public void tc04() throws InterruptedException {
		
		System.out.println("Test Started");
		System.out.println(System.getProperty("user.dir"));
		//Assert.assertEquals("HardAssert", "HardAssertion");
		System.out.println("Test Finished");
		
	}*/
	
	@Test(priority = 1,enabled = true)
	public void tc01() throws InterruptedException {
		logger=extent.createTest("TC01");
		
		pageObjectManager = new PageObjectManager(driver);
		homepage = pageObjectManager.getHomePage();
		homepage.setsearchfieldtxt("8925497");
		logger.log(Status.INFO, "Product ID entered");
		homepage.clickSearchbtn();
		logger.log(Status.INFO, "search button clicked");
		searchpage = pageObjectManager.getSearchResultPage();
		logger.log(Status.INFO, "searched results");
		searchpage.clickproduct();
		logger.log(Status.INFO, "clicked product");
		productpage = pageObjectManager.getProductPage();
		Thread.sleep(5000);
		productpage.addtocartbtn();
		logger.log(Status.INFO, "clicked add to cart button");
		productpage.checkoutbtn();
		logger.log(Status.INFO, "click checkout button");
		cartpage = pageObjectManager.getcartpage();
		Thread.sleep(5);
		//cartpage.selectshiptohome();
		//cartpage.clickcheckoutbtn();
        //Assert.assertEquals("HardAssert", "HardAssertion");
		System.out.println("finished test1");
		logger.pass("Test case Passed");		
	}
	
	@Test (enabled = false,priority = -2)
	public void tc02() {
		System.out.println("entered test2");
		pageObjectManager = new PageObjectManager(driver);
		homepage = pageObjectManager.getHomePage();
		homepage.setsearchfieldtxt("8925497");
		homepage.clickSearchbtn();
		searchpage = pageObjectManager.getSearchResultPage();
		searchpage.clickproduct();
		System.out.println("finished test2");
	}
	
	@Test(enabled = false)
	public void tc03() {
		System.out.println("entered test3");
		pageObjectManager = new PageObjectManager(driver);
		homepage = pageObjectManager.getHomePage();
		homepage.setsearchfieldtxt("8925497");
		homepage.clickSearchbtn();
		searchpage = pageObjectManager.getSearchResultPage();
		searchpage.clickproduct();
		System.out.println("finished test3");
	}

}
