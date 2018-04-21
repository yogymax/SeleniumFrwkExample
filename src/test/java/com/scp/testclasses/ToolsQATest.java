package com.scp.testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.scp.appconstants.WebDriverInitialization;
import com.scp.web.pageobjects.ToolsQAPageObject;
import com.scp.appconstants.*;


public class ToolsQATest {
	long delayTime = 3000;	
	
  @Test(enabled=false)
  public void fillToolsQAPracticeForm() throws InterruptedException {
	  WebDriver driver = WebDriverInitialization.getDriver(ApplicationConstants.BrowserTypes.FIREFOX,ApplicationConstants.TOOLS_QA_URL);
	  ToolsQAPageObject toolsQAPage = PageFactory.initElements(driver, ToolsQAPageObject.class);
	  toolsQAPage.enterUserData("Xyz","PQR");
	  Thread.sleep(delayTime);
	  toolsQAPage.selectGender(ApplicationConstants.GenderTypes.Male);
	  Thread.sleep(delayTime);
	  toolsQAPage.yearOfExp(7);
	  Thread.sleep(delayTime);
	  WebDriverInitialization.scrollPage(ApplicationConstants.ScrollType.Down);
	  Thread.sleep(delayTime);
	  toolsQAPage.enterDate("21/04/2018");
	  Thread.sleep(delayTime);
	  toolsQAPage.selectProfession("Manual Tester","Automation Tester");
	  Thread.sleep(delayTime);
	  toolsQAPage.selectAutomationTools("Selenium IDE","Selenium Webdriver");
	  Thread.sleep(delayTime);
	  toolsQAPage.selectCountry("Africa");
	  Thread.sleep(delayTime);
	  toolsQAPage.selectSeleniumCommands("WebElement Commands","Switch Commands","Browser Commands");
	  Thread.sleep(delayTime);
	  WebDriverInitialization.scrollPage(ApplicationConstants.ScrollType.Up);
	  Thread.sleep(delayTime);
	  WebDriverInitialization.scrollPage(ApplicationConstants.ScrollType.Up);
	  
  }
  
  
  @Test
  public void uploadFileUsingRobotClasses(){
	  WebDriver driver = WebDriverInitialization.getDriver(ApplicationConstants.BrowserTypes.FIREFOX,ApplicationConstants.TOOLS_QA_URL);
	  WebDriverInitialization.scrollPage(ApplicationConstants.ScrollType.Down);
	  ToolsQAPageObject toolsQAPage = PageFactory.initElements(driver, ToolsQAPageObject.class);
	  //toolsQAPage.uploadFile("C:\\Users\\XYZ\\Desktop\\J#7\\test.txt");
	  toolsQAPage.uploadFile("C:\\Users\\XYZ\\Desktop\\Patterns\\fileUploadScript.exe"); //This is specifically for AUTOITv3
  }
  
  
}
