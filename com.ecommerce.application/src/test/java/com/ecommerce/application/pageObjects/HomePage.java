package com.ecommerce.application.pageObjects;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how=How.XPATH, using = ".//input[@title='Search for products, brands and more']")
	WebElement txt_searchProduct;

	@FindBy(how=How.XPATH, using = ".//*[name()='svg']")
	WebElement btn_Search;

	@FindBy(how=How.XPATH, using = ".//img[@alt='Prestige Tattva Copper Bottle TCB 04 1000 ml Bottle']")
	WebElement btn_bottle;
	
	@FindBy(how=How.XPATH, using = ".//button[@type='button']")
	WebElement btn_Buynow;

	//Methods
	public void setProductname(String productName) {
		txt_searchProduct.clear();
		txt_searchProduct.sendKeys(productName);
		Reporter.log("Productname entered is :"+ productName);
	}

	public void clickSearch() {
		Actions actionBuilder = new Actions(driver);
		actionBuilder.click(btn_Search).build().perform();
	}

	public void clickBottle() {
		btn_bottle.click();
	}
	
	public void clickBuynow() {
		btn_Buynow.click();
	}

	//Implementation Method
	public void checkoutProduct(String productName) {

		setProductname(productName);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		clickSearch();
		clickBottle();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		clickBuynow();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		driver.quit();
	}
}

