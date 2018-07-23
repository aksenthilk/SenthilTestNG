package com.extent;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Functionality3 {
	@Test
	public void sen(){
		ExtentHtmlReporter report = new ExtentHtmlReporter("./SenthlTestNG/ReportExtent/extent.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
	
	}

}
