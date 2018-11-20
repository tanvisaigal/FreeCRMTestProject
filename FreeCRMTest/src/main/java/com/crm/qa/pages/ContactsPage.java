package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlabel;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath = ".//*[@type='submit' and @value ='Save']")
	WebElement savebtn;


public ContactsPage(){
	PageFactory.initElements(driver, this);
}
//public boolean selectContacts() throws InterruptedException{
//	Thread.sleep(2000);
//	WebElement checkContact = driver.findElement(By.xpath("//a[contains(text(),'Myra Saigal')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']']"));
//	checkContact.click();
//	return checkContact.isSelected();
//}


public boolean contactsLabel(){
	return contactlabel.isDisplayed();
}

public void addNewContact(String title1, String fname, String lname, String comp){
	Select s = new Select(title);
	s.selectByVisibleText(title1);
	firstname.sendKeys(fname);
	lastname.sendKeys(lname);
	company.sendKeys(comp);
	savebtn.click();
}








}
//