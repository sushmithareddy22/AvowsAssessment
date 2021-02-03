package com.ecommerce.application.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.application.pageObjects.HomePage;
import com.ecommerce.application.pageObjects.LoginPage;
import com.ecommerce.application.utils.BrowserManager;

public class TC_ProductCheckout {
	
	
	@Test
	@Parameters({ "browsername", "url" })
	public void t_01_ecommerce_checkout(String browsername,String url) {
		
		WebDriver driver = BrowserManager.getDriver(browsername,url);
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("charanabhi797@gmail.com", "svignan999");
		
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.checkoutProduct("Water bottle");
		
		
	
		
	}

}
