package com.crm.testcases;

import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

import org.testng.annotations.BeforeMethod;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	SignUpPage signuppage;
	
	
	public LoginPageTest(){
		super();
	}
	
	 @BeforeMethod
	  public void setUp() {
		 intialization();
		 loginpage = new LoginPage();
		 
	
		 
	  }

	
  @Test(priority=1)
  public void loginpagetitletest() {
	  String loginTitle = loginpage.validateLoginPageTitle();
	  System.out.println(loginTitle);
	  Assert.assertEquals(loginTitle, "#1 Free CRM software in the cloud for sales and service");
  }
  
  @Test(priority =2)
  public void CRMimagetest(){
	  boolean flag = loginpage.validateCRMimage();
	  Assert.assertTrue(flag);
  }
  
  @Test(priority=3)
  public void loginpagetest() throws InterruptedException{
	  homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));  
 }
 
  @Test
  public void signuppagetest() throws InterruptedException{
	  signuppage = loginpage.ValidateSignup();
  }
 
  @AfterMethod
  public void tearDown() {
	  driver.close();
	  driver.quit();
  }
  
  }


