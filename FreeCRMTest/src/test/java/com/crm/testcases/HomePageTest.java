package com.crm.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	TestUtil testutil;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod()
	public void setUp() throws InterruptedException{
		intialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		homepage = new HomePage();
	}
	@Test(priority=1)
	public void verifyHomePagetitleTest(){
		String homepagetitle = homepage.verifyHomePagetitle();
		System.out.println(homepagetitle);
		Assert.assertEquals(homepagetitle, "CRMPRO","Title is not correct");
		}
	
	@Test()
	public void contactspageTest(){
		testutil.switchtoframe();
		contactspage = homepage.clickonContactsPage();
	}

	@Test()
	public void dealspageTest(){
		testutil.switchtoframe();
		dealspage = homepage.clickonDealsPage();
	}
	@Test()
	public void taskspageTest(){
		testutil.switchtoframe();
		taskspage = homepage.clickonTasksPage();
	}
	@Test(priority=1)
	public void usernamedisplayTest(){
		testutil.switchtoframe();
		Assert.assertTrue(homepage.validateUsername());
	}
	
	@AfterMethod()
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
}
