package com.qa.automationpractice.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {

	WebDriver driver;
	Properties prop= new Properties();
	
	
	public ElementActions(WebDriver driver1) {
		this.driver= driver1;
	}
		public void sendkeys(By Selector, String USER) {
		driver.findElement(Selector).sendKeys(prop.getProperty("USER"));
		
	}
		public void click(By Selector) {
			driver.findElement(Selector).click();
			
		}
		
		public String gettitle() {		
				String tit=driver.getTitle();
				System.out.println(tit);
				return tit;
		}
		
		public void time(int value) throws InterruptedException {
			Thread.sleep(value);
		}
		public void screenshot(WebDriver driver1, String filename) throws IOException {
			File Scrfile= ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
			File destFile= new File(filename);
			FileUtils.copyFile(Scrfile, destFile);
		}
        public void select(WebElement from,String x) {
        	Select obj= new Select(from);
        	obj.selectByVisibleText(x);
}
        public void TotalPageLinks(String url) {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The number of links is " + links.size());
        	 }
        

}

