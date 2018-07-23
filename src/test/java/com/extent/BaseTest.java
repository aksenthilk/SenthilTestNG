package com.extent;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class BaseTest {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
	public void setUp(){
		 htmlReporter = new ExtentHtmlReporter("./test-output/SenthilExtentReport.html");
		 extent = new com.aventstack.extentreports.ExtentReports();
		 extent.attachReporter(htmlReporter);		
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
	public void tesrDown(){
		extent.flush();
		
		
	}
}
