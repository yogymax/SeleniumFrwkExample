package com.scp.appconstants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.scp.appconstants.ApplicationConstants.BrowserTypes;

public class WebDriverInitialization {
	public static WebDriver driver = null;
	
	
	public static WebDriver getDriver(BrowserTypes type,String url){
		switch(type){
			 case FIREFOX :
				 System.setProperty("webdriver.gecko.driver", "E:\\MySofts\\geckodriver-v0.19.0-win64\\geckodriver.exe");
				 driver = new FirefoxDriver();
				 break;
			 case CHROME:
				 System.setProperty("webdriver.chrome.driver", "E:\\MySofts\\chromedriver_win32\\chromedriver.exe");
				 driver = new ChromeDriver();
				 break;
			 case SAFARI:
				 driver = new SafariDriver();
				 break;
			 case IE:
				 driver = new InternetExplorerDriver();
				 break;
			default :
				System.out.println("specificd browser not available.....");
		}
		
		driver.get(url);
		return driver;
	}

}
