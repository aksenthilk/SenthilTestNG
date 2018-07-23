package com.extent;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Functionality1 extends BaseTest{
	@Test
	public void functionalityTest1(){
		test = extent.createTest("FunctionalityTest1");
				Assert.assertTrue(1>0);
		
	}
	@Test
	public void functionalityTest2(){
		test = extent.createTest("FunctionalityTest2");
		Assert.assertEquals("Senthil","Kumar");
	}
	
	@Test
	public void functionalityTest3(){
		test = extent.createTest("FunctionalityTest3");
		Assert.assertEquals("Senthil","Senthil");
	}

}
