package com.scp.testclasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.scp.appconstants.*;
import com.scp.appconstants.WebDriverInitialization;
import com.scp.util.excereadwrite.ExcelReadWriteUtil;
import com.scp.web.pageobjects.DashboardPageObject;
import com.scp.web.pageobjects.LoginPageObject;

public class OrangeHRMLoginTest {

	
	/**
	 * 
	 * suite -- all test cases which covers entire application tests
	 * Class -- test cases present within a test class -- specifc to module
	 * Test -- logical grouping of your test classes
	 * Group --- Logical grouping of your test methods
	 * Method --- single test case
	 */
	
	@Test(enabled=false)
	public void check_user_login_with_valid_credetials_should_display_dashboard(){
		/*
		 * Steps
		 * Launch a browser
		 * Enter App URL
		 * Enter valid Username (Admin)
		 * Enter valid Password (admin)
		 * Click on Login button
		 * Dashboard page with Menu should be displayed
		 */

		System.out.println("Step1 : - Launch a browser and enter a url");
		System.out.println("Expected : - Browser should be opened and login page should be displayed");
		WebDriver driver = WebDriverInitialization.getDriver(ApplicationConstants.BrowserTypes.FIREFOX, ApplicationConstants.APPLICATION_LOGIN_URL);
		
		System.out.println("Step2 :Enter valid username and password");
		System.out.println("Expected :User should able to enter username and password");
		driver.findElement(By.id("txtUsername")).sendKeys(ApplicationConstants.USERNAME+1);
		driver.findElement(By.id("txtPassword")).sendKeys(ApplicationConstants.PASSWORD);
		
		
		System.out.println("Step3 :Click on LoginButton");
		System.out.println("Expected :Dashboard page with menu should be displayed");
		driver.findElement(By.id("btnLogin")).click();

		WebElement welCome = driver.findElement(By.id("welcome"));
		System.out.println(welCome.getText());
		
		Assert.assertNotNull(welCome);
		Assert.assertEquals(welCome.getText(),"Welcome Admin");
		
		//Assert.assertNotNull(driver.findElement(By.className("menu")));
		
	}
	
	
	@Test(enabled=false)
	public void check_user_login_with_valid_credetials_should_display_dashboard_v2(){
		
		System.out.println("Step1 : - Launch a browser and enter a url");
		System.out.println("Expected : - Browser should be opened and login page should be displayed");
		WebDriver driver = WebDriverInitialization.getDriver(ApplicationConstants.BrowserTypes.FIREFOX, ApplicationConstants.APPLICATION_LOGIN_URL);
		
		System.out.println("Step2 :Enter valid username and password");
		System.out.println("Expected :User should able to enter username and password");
		//driver.findElement(By.id("txtUsername")).sendKeys(ApplicationConstants.USERNAME+1);
		//driver.findElement(By.id("txtPassword")).sendKeys(ApplicationConstants.PASSWORD);
		LoginPageObject loginPage = PageFactory.initElements(driver, LoginPageObject.class);
		loginPage.enterUserName(ApplicationConstants.USERNAME);
		loginPage.enterPassword(ApplicationConstants.PASSWORD);
		
		System.out.println("Step3 :Click on LoginButton");
		System.out.println("Expected :Dashboard page with menu should be displayed");
		//driver.findElement(By.id("btnLogin")).click();
		DashboardPageObject dashboard = loginPage.clickOnLogin();
		Assert.assertTrue(dashboard.isPageLoaded());
		
		/*WebElement welCome = driver.findElement(By.id("welcome"));
		System.out.println(welCome.getText());
		
		Assert.assertNotNull(welCome);
		Assert.assertEquals(welCome.getText(),"Welcome Admin");
		*/
		//Assert.assertNotNull(driver.findElement(By.className("menu")));
		
	}

	
	
	
	@DataProvider
	public Object [] [] userData() throws IOException{
		return ExcelReadWriteUtil.readTestDataFromExcel();
		
		
		//		Object [] []  udata = 
				
		/*new Object[8][3];
		
		
		udata[1][0]="";
		udata[1][1]="";
		udata[1][2]="Username cannot be empty";

		udata[2][0]="";
		udata[2][1]="aaaas123";
		udata[2][2]="Username cannot be empty";

		udata[3][0]="aaaa";
		udata[3][1]="sasasaaa";
		udata[3][2]="Invalid credentials";

		udata[4][0]="aaaaaa";
		udata[4][1]="";
		udata[4][2]="Password cannot be empty";

		udata[5][0]="Admin";
		udata[5][1]="Admin";
		udata[5][2]="Invalid credentials"; 
		
		
		udata[6][0]="admin";
		udata[6][1]="admin";
		udata[6][2]="Invalid credentials"; 
		
		
		udata[0][0]="admin";
		udata[0][1]="Admin";
		udata[0][2]="Invalid credentials"; 
		
		
		udata[7][0]="Admin";
		udata[7][1]="admin";
		udata[7][2]="Success"; // Dashaboard should return true
		
		return udata;
*/	}
	
	
	/**
	 * 
	 * Webdriver methods
	 * WEbElements
	 * 
	 * How to automate Dropdown -- Select class
	 * Mousehover -- Actions
	 * listout locators
	 * 
	 * http://toolsqa.com/automation-practice-form/ -- try this...
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param username
	 * @param password
	 * @param emsg
	 */
	
	@Test(dataProvider="userData",enabled=true)
	public void check_user_login_with_valid_credetials_should_display_dashboard_v3(String username,String password,String emsg){
		
		
		
		System.out.println("Step1 : - Launch a browser and enter a url");
		System.out.println("Expected : - Browser should be opened and login page should be displayed");
		WebDriver driver = WebDriverInitialization.getDriver(ApplicationConstants.BrowserTypes.FIREFOX, ApplicationConstants.APPLICATION_LOGIN_URL);
		
		System.out.println("Step2 :Enter valid username and password");
		System.out.println("Expected :User should able to enter username and password");
		LoginPageObject loginPage = PageFactory.initElements(driver, LoginPageObject.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		
		System.out.println("Step3 :Click on LoginButton");
		System.out.println("Expected :Dashboard page with menu should be displayed");
		
		if(emsg.equals("Success")){
			DashboardPageObject dashboard = loginPage.clickOnLogin();
			Assert.assertTrue(dashboard.isPageLoaded());
		}else{
			loginPage.clickOnLoginWithoutDashboard();
			String actualMessage = loginPage.getErrorMessage();
			Assert.assertEquals(actualMessage,emsg);
		}
		
	}

	
	
}
