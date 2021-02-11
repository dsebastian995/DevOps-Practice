package com.qa.automationpractice.basepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.automationpractice.utils.ElementActions;

/**
 * 
 * @author Owner
 *
 */
public class LoginPage extends BasePage {
	public WebDriver driver;
	ElementActions actions;

//	public static void main(String[] args) {

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		actions = new ElementActions(driver);

	}

	By MyAccount = By.xpath("//i[@class='fa fa-user']");
	By ClickLogin = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");

	By email = By.xpath("//input[@id='input-email']");
	By pass = By.xpath("//input[@id='input-password']");

	By login = By.xpath("//input[@value='Login']");

	By Verify = By.xpath("//h2[normalize-space()='My Affiliate Account']");
	
//	Input a string
	By Search= By.xpath("//input[@placeholder='Search']");
	By SearchButton= By.xpath("//i[@class='fa fa-search']");

	/**
	 * 
	 * @return This method returns Home
	 * @throws InterruptedException 
	 */
	
	public WebDriver SearchProducts() throws InterruptedException {
		driver.findElement(Search).sendKeys("Samsung");
		actions.click(SearchButton);
		Thread.sleep(3000);
		return driver;
		
	}
	public WebDriver LetsLogin() {
		System.out.println("loginpage method");
		actions.click(MyAccount);
		actions.click(ClickLogin);
		actions.sendkeys(email, "username");
		actions.sendkeys(pass, "password");
		actions.click(login);

		return driver;
	}

	public Boolean verifyPage() {
		Boolean flag = driver.findElement(Verify).isDisplayed();
		return flag;

	}
}
