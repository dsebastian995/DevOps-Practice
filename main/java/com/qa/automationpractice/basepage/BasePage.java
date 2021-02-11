package com.qa.automationpractice.basepage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;
	public Properties prop;
	
	public BasePage (WebDriver driver) {
//		super(driver1);
		this.driver = driver;
	}
	
//1.initializing browser	
	public WebDriver init_driver (String browser) {
		System.out.println("Browser Value is "+ browser);
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
		else {
			 System.out.println("Please select chrome,edge or firefox");
		}
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		
		return driver;
		
		
		
		
	}
//2.loading properties
	
	public Properties init_proper() throws IOException {
		prop=new Properties();
		FileInputStream inp=new FileInputStream("C:\\Users\\Owner\\eclipse-workspace\\POMSERIES\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(inp);
		return prop;
	}
	
}




