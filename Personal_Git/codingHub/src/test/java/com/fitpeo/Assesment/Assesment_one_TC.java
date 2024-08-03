package com.fitpeo.Assesment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.BaseTest;
import com.pages.HomePage;
import com.utility.WebDriverUtils;

public class Assesment_one_TC extends BaseTest{
	
	 
	
	@Test()
	public void firstMethod() throws InterruptedException {
		
		System.out.println(driver+" test class>>>>>>>>>>>>>>>>>>> ");
		
		HomePage homePage=new HomePage(driver);
		System.out.println("clicked successfully "+homePage.getUrl());
		
		Assert.assertTrue(WebDriverUtils.ClickToElement(homePage.getRevenueHeader(), 20));
		System.out.println("clicked successfully ");
		
		String text = WebDriverUtils.getText(homePage.getMainHeader(), 20);
		
		System.out.println("header name is "+text);
		Thread.sleep(15000);
		WebDriverUtils.VerifyText(homePage.getMainHeader(), "text is Remote Patient\r\n"+ "Monitoring", 20);
		
		String text1 = WebDriverUtils.getText(homePage.getMainHeader(), 20);
		
		System.out.println("text is "+text1);
		
	}
	
	@Test()
	public void secondMethod() throws InterruptedException {
		
		HomePage homePage=new HomePage(driver);
		Thread.sleep(10000);
		WebDriverUtils.addToValue(homePage.textField(), "110", 20);
		Thread.sleep(10000);
		
	}
	

}
