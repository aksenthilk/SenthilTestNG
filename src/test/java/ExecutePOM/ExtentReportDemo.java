package ExecutePOM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {
	WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	
	/*@BeforeTest
	public void start(){
		 System.out.println("Starting the report");
		
		
		
	}*/
	@BeforeTest
	public void setUp(){
		 System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		 driver = new ChromeDriver();
		 reporter = new ExtentHtmlReporter("./Reports/senExtent.html");
		 extent = new ExtentReports();
		 extent.attachReporter(reporter);
		
	}
	
	/*@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}*/
	
	@AfterTest
	public void tearDown(){
		//driver.quit();
		 extent.flush();
		 
		 
		driver.quit();
		 
		
	}
	
	@Test
	public void loginTest() throws InterruptedException{
		System.out.println("Senthil and Shital are Expecting Pillu");
		driver.get("http://www.justanswer.com");
		/*ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/senExtent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
	    ExtentTest logger=extent.createTest("LoginTest"); 
	    logger.log(Status.INFO, "Login to senthil");
	    extent.flush();*/
		ExtentTest logger1=extent.createTest("LoginTest"); 
	    logger1.log(Status.INFO, "Login to senthil");
	    Thread.sleep(4000);
	   // Assert.assertEquals("Senthil","Sendil");
	    Assert.assertEquals("Ask an Expert & Get Answers to Your senthil - ASAP", driver.getTitle());
	    Thread.sleep(3000);
	    
	 // extent.flush();
		
	}
	@Test
	public void registerTest(){
		System.out.println("Senthil and Shital are Expecting Pillu");
		driver.get("http://www.yahoo.com");
		/*ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/senExtent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
	    ExtentTest logger=extent.createTest("LoginTest"); 
	    logger.log(Status.INFO, "Login to senthil");
	    extent.flush();*/
		ExtentTest logger2=extent.createTest("YahooTest"); 
	    logger2.log(Status.INFO, "Login to YAhoo");
	  // extent.flush();
		
	}

}
