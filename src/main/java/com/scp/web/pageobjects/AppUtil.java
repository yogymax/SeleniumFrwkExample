package com.scp.web.pageobjects;

import org.openqa.selenium.WebElement;

public class AppUtil {

	
	
	public static boolean checkElement(WebElement element){
		try{
			return element.isDisplayed();
		}catch(Exception e){
			return false;
		}
	}
	
}
