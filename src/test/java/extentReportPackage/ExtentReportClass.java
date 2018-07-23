
package extentReportPackage;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogLevel;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportClass {
	
	//https://www.softwaretestingmaterial.com/
	
		/*<!-- https://mvnrepository.com/artifact/com.relevantcodes/extentreports -->
			<dependency>
			    <groupId>com.relevantcodes</groupId>
			    <artifactId>extentreports</artifactId>
			    <version>2.41.2</version>
			</dependency>*/
		
		ExtentReports extent;
		ExtentTest logger;
		WebDriver driver;
		
		@BeforeTest
		public void startTest(){
			
			extent = new ExtentReports("./Reports/SenExtentReport.html", true);
			extent.addSystemInfo("Host Name", "Sen Soft");
			extent.addSystemInfo("Environment", "Automation");
			extent.addSystemInfo("USer Name:", "Senthil");
			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
			 
			
		}
		
		@BeforeMethod
		public void startup(){
			System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
	    
		@Test
		public void justanswerTest() throws InterruptedException{
			logger = extent.startTest("PassTest");
			Assert.assertTrue(true);
		//	logger.log(LogStatus.PASS, "Test case Passed is PassTest");
			logger.getRunStatus();
			System.out.println("Senthil and Shital are Expecting Pillu");
			driver.get("http://www.justanswer.com");
			 Assert.assertEquals("Ask an Expert & Get Answers to Your Questions - ASAP", driver.getTitle());
			    Thread.sleep(3000);
			    driver.close();
			
		}
		
		@Test
		public void yahooTest(){
			logger = extent.startTest("FailTest");
			
			//logger.log(LogStatus.FAIL, "Test case Failed is FailTest");
			System.out.println("Senthil and Shital are Expecting Pillu");
			driver.get("http://www.google.com");
			Assert.assertTrue(false);
		}
		
		/*@Test
		public void skipTest(){
			logger = extent.startTest("SkipTest");
			//Assert.assertTrue(false);
			throw new SkipException("Skipped this Test is not ready for Testing");
			
		}*/
		
		@AfterMethod
		public void getResult(ITestResult result){
			
			if(result.getStatus()==ITestResult.FAILURE){
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is"+result.getThrowable());
			}else if(result.getStatus()==ITestResult.SKIP){
				logger.log(LogStatus.SKIP, "Test Case Failed is"+result.getName());
			}
			extent.endTest(logger);
			//driver.close();
			
		}
		
		@AfterTest
		public void endReport(){
			
			extent.flush();
			extent.close();
			
			
		}
	
	

}
