package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.base.TestBase;

public class LoginPage extends TestBase  {
	
	WebDriverWait wait = new WebDriverWait(driver, 500);
	
	
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath=".//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath=".//img[contains(@alt,'free crm logo')]")
	WebElement crmLogo;
	
	@FindBy(xpath="//font[contains(text(),'Sign Up')]")
	WebElement signup;
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
		
	}
	
	public boolean validateCRMimage(){
		return crmLogo.isDisplayed();		
	}
	
	public HomePage Login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		Thread.sleep(2000);
		loginbtn.click();
		return new HomePage();
	}
	
	public SignUpPage ValidateSignup() throws InterruptedException{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(signup));
		signup.click();
		
		return new SignUpPage();
		
	}
	
	

}
