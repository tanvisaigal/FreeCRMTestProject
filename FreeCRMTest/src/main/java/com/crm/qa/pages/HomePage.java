package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: Tanvi Saigal')]")
	WebElement loginlabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactslink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealslink;

	@FindBy(xpath="//a[@title='Tasks']")
	WebElement taskslink;
	
	@FindBy(xpath=".//*[@title='New Contact']")
	WebElement newcontact;


public HomePage(){
	
	PageFactory.initElements(driver, this);
}

public String verifyHomePagetitle(){
	
	return driver.getTitle();
	
}


public ContactsPage clickonContactsPage(){
	contactslink.click();
	return new ContactsPage();
	
}
public DealsPage clickonDealsPage(){
	dealslink.click();
	return new DealsPage();
	
}
public TasksPage clickonTasksPage(){
	taskslink.click();
	return new TasksPage();
	
}
public boolean validateUsername(){
	return loginlabel.isDisplayed(); 
	
}
public void selectNewContact(){
	Actions action = new Actions(driver);
	action.moveToElement(contactslink).build().perform();
	newcontact.click();
}







	
}
