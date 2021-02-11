package com.qa.automationpractice.basetest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import com.qa.automationpractice.basepage.BasePage;
import com.qa.automationpractice.basepage.LoginPage;



public class Basetest {
	public WebDriver driver;
	public BasePage basepage;
	public Properties prop;
	public LoginPage login;
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		
	@BeforeTest
		
		public void Setup() throws IOException{
			 basepage=new BasePage(driver);
			 prop= basepage.init_proper();
			 
			String browser= prop.getProperty("browser");
			WebDriver driver= basepage.init_driver(browser);
			login=new LoginPage(driver);
			driver.get(prop.getProperty("url"));
			System.out.println("yes");
		
			
	}
			
			
		@AfterTest
		
		public void close() throws InterruptedException {
			driver=login.SearchProducts();
			driver.quit();
			
			 

	}

}


