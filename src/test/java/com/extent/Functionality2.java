package com.extent;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Functionality2 extends BaseTest {
	@Test
	public void functionality2Test1(){
		test = extent.createTest("Functionality2Test1");
				Assert.assertTrue(1>0);
		
	}
	@Test
	public void functionality2Test2(){
		test = extent.createTest("Functionality2Test2");
		Assert.assertEquals("Senthil","Kumar");
	}
	
	@Test
	public void functionality2Test3(){
		test = extent.createTest("Functionality3Test3");
		Assert.assertEquals("Senthil","Senthil");
	}

}
