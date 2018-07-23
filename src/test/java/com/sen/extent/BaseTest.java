package com.sen.extent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class BaseTest {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	@BeforeSuite
	public void setUp(){
		 htmlReporter = new ExtentHtmlReporter("./NewExtentReport/SenthilExtentReport.html");
		 extent = new com.aventstack.extentreports.ExtentReports();
		 extent.attachReporter(htmlReporter);		
	}
	@BeforeMethod
	public void startBrowser(){
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver.exe");
		
		
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result){		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail(MarkupHelper.createLabel(result.getName()+"Test Case Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			test.pass(MarkupHelper.createLabel(result.getName()+"Test Case Passed", ExtentColor.GREEN));
			
		}
		else{
			test.skip(MarkupHelper.createLabel(result.getName()+"Test Case Skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
		
		
	}
	
	@AfterSuite
	public void tearDown(){
		extent.flush();
		
		
	}
}
