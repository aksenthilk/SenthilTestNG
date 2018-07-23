package com.sen.extent;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Functionality2 extends BaseTest {
	
	@Test
	public void functionality2Test1(){
		/*test = extent.createTest("Functionality2Test2");
		Assert.assertEquals("Senthil","Kumar");*/
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		//driver.close();
	}
	@Test
	public void functionality2Test2(){
		/*test = extent.createTest("Functionality2Test1");
				Assert.assertTrue(1>0);*/
		driver = new ChromeDriver();
		driver.get("http://www.justanswer.com");
		Assert.assertEquals("Ask an Expert & Get Answers to Your Questions - ASAP", driver.getTitle());
		//driver.close();
	}
	
	
	@Test
	public void functionality2Test3(){
		/*test = extent.createTest("Functionality3Test3");
		Assert.assertEquals("Senthil","Senthil");*/
		driver = new ChromeDriver();
		driver.get("http://www.freecrm.com");
		Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", driver.getTitle());
		//driver.close();
	}

}
