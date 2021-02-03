package com.ecommerce.application.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {
	
	WebDriver driver;
	
//	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	
	@FindBy(how=How.XPATH, using = "(.//input[@type='text'])[2]")
	WebElement txt_Username;
	
	@FindBy(how=How.XPATH, using = ".//input[@type='password']")
	WebElement txt_Password;
	
	@FindBy(how=How.XPATH, using = "(.//button[@type='submit'])[2]")
	WebElement btn_Login;
	
	@FindBy(how=How.XPATH, using = ".//*[contains(text(),'Abhishek')]")
	WebElement txt_Userloggedin;
	
	
	//Methods
	public void setUsername(String username) {
		txt_Username.sendKeys(username);
		Reporter.log("Username entered is :"+ username);
	}
	
	public void setPassword(String password) {
		txt_Password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_Login.click();
	}
	
	//Implementation Method
	public void login(String username, String password) {
		
		setUsername(username);
		setPassword(password);
		clickLogin();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(text(),'Abhishek')]")));
		
	}
}
