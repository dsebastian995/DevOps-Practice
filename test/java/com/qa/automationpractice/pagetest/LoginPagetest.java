package com.qa.automationpractice.pagetest;



import org.testng.annotations.Test;

import com.qa.automationpractice.basetest.Basetest;

import okio.Timeout;



public class LoginPagetest extends Basetest {

	@Test(priority=1)

	public void sampletest() throws InterruptedException {
		login.SearchProducts();
		
		
	}

	
	
	
	@Test(priority=2 ,enabled=false)

	public void LoginTest() {
		login.LetsLogin();

	}

}
