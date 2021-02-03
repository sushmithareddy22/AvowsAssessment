package com.ecommerce.application.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserManager {
	
	public static WebDriver getDriver(String browsername,String url) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/chromedriver.exe");
		WebDriver driver=null;
		
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		Reporter.log("Navigated to browser: "+browsername+" URL: "+url);
		
		return driver;
		
		
	}

}
