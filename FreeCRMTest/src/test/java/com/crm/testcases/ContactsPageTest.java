package com.crm.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	TestUtil testutil;
	String sheetName = "Data1";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod()
	public void setUp() throws InterruptedException{
		intialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		homepage = new HomePage();
		testutil.switchtoframe();
		contactspage = homepage.clickonContactsPage();
		contactspage = new ContactsPage();
		}
	
	@Test(priority=1)
	public void checkContactslabelTest(){
		boolean check = contactspage.contactsLabel();
		Assert.assertTrue(check);
	}
	
//	@Test()
//	public void selectContactsTest() throws InterruptedException{
//		boolean checkcontacts = contactspage.selectContacts();
//		Assert.assertTrue(checkcontacts);
//	}
	@DataProvider
	public Object[][] getCRMtestdata() throws InvalidFormatException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	@Test(priority=2, dataProvider="getCRMtestdata")
	public void validateNewContacttest(String Title, String Firstname, String Lastname, String Company ){
		homepage.selectNewContact();
		//contactspage.addNewContact("Mr.",  "Ram", "Sharma", "Amazon");
		contactspage.addNewContact(Title,  Firstname, Lastname, Company);
		
	}

	@AfterMethod()
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
	

}
