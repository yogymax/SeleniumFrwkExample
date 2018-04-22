package com.scp.appconstants;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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


	public static void scrollPage(ApplicationConstants.ScrollType type){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		if("up".equalsIgnoreCase(type.toString())){
			for(int i=0;i<3;i++)
			jse.executeScript("window.scrollBy(0,-250)", "");  //jse.executeScript("scroll(0, -250);");
		}else{
			for(int i=0;i<3;i++)
			jse.executeScript("window.scrollBy(0,250)", "");  //jse.executeScript("scroll(0, 250);");
		}
		
	}

	
	public static void closeDriver(){
		if(null!=driver)
			driver.quit();
	}
	
	public static void copyContentInSystemClipboard(String contents){
		StringSelection stringSelection = new StringSelection(contents);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
	
	public static void launchProgram(String path){
		try {
			Thread.sleep(3000);
			Runtime.getRuntime().exec(path); //
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	

}
