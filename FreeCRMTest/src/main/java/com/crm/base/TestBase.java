package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	 public static WebEventListener eventlistner;
	 
	 
	
	public  TestBase() {
		
		try{
		prop = new Properties();
		FileInputStream ip = new FileInputStream("/Users/chandernita/Desktop/Selenium/Selenium_ Workspace/FreeCRMTest/src/main/java/com/crm/config/config.properties");
		prop.load(ip);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void intialization(){
		
		String browsername = prop.getProperty("browser");
	if(browsername.equals("firefox")){
		System.setProperty("webdriver.gecko.driver","/Users/chandernita/Desktop/Selenium/Selenium_ Workspace/FreeCRMTest/geckodriver");
		driver=new FirefoxDriver();
	}else if(browsername.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","/Users/chandernita/Desktop/Selenium/Selenium_ Workspace/FreeCRMTest/chromedriver");
			driver = new ChromeDriver();
}
		e_driver = new EventFiringWebDriver(driver);
		eventlistner = new WebEventListener();
		e_driver.register(eventlistner);
		driver = e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));	
		
	}

}
