package TestNG_Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.SearchResultPage;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import utils.Utility;

import java.lang.reflect.Method; 
public class BaseTest {
	
	WebDriver driver;
	HomePage homepage;
	ProductPage productpage;
	SearchResultPage searchpage;
	CartPage cartpage;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	ExtentTest logger;
	
	
		
	@BeforeSuite(groups = { "functest" })
	public void setupsuite() {
		//System.out.println("Before suite entered");
		reporter=new ExtentHtmlReporter("./Reports/SmokeTest.html");
		reporter.loadXMLConfig(FileReaderManager.getInstance().getConfigReader().getReportConfigPath());
		extent = new ExtentReports();
	    extent.attachReporter(reporter);
	    //System.out.println("Before Suite executed");
	    
	}
		
	@BeforeMethod(groups = { "functest" })
	public void beforemethod(Method method)  throws Exception{
		//System.out.println("Before method entered");
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get("https://www.acehardware.com");
		//System.out.println("Before Class executed");
		//String testName = method.getName();
		//logger=extent.createTest(testName);
	}
	
	
	@AfterMethod(groups = { "functest" })
	public void teardown(ITestResult result) throws IOException {
		System.out.println("After method entered");
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=Utility.getScreenshot(driver);
			//logger.fail(result.getThrowable().getMessage());
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
        	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
        	logger.skip(result.getThrowable());
        } 
		
		webDriverManager.closeDriver();
		
	}

	 	
	@AfterSuite(groups = { "functest" })
	public void teardownsuite() {
		//System.out.println("After test entered");
		extent.flush();
		//System.out.println("After test executed");
		
	} 
	

}
