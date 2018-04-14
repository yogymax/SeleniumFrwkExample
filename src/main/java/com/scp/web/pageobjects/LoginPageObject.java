package com.scp.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.scp.appconstants.WebDriverInitialization;
import com.scp.util.AppContracts;

public class LoginPageObject implements AppContracts {

	@FindBy(id="txtUsername")
	WebElement userName;   //WebElement userName=driver.findElement(By.id("txtUsername"))
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	@FindBy(id="spanMessage")
	WebElement errorMsg;
	
	
	
	public void enterUserName(String uname){
		userName.clear();
		userName.sendKeys(uname);
	}
	
	
	public void enterPassword(String pwd){
		password.clear();
		password.sendKeys(pwd);
	}
	
	public DashboardPageObject clickOnLogin(){
		loginBtn.click();
		return PageFactory.initElements(WebDriverInitialization.driver, DashboardPageObject.class);
	}
	
	public void clickOnLoginWithoutDashboard(){
		loginBtn.click();
	}
	
	
	public String getErrorMessage(){
		if(AppUtil.checkElement(errorMsg))
				return errorMsg.getText();
		else 
			return null;
			
	}


	public boolean isPageLoaded() {
		return AppUtil.checkElement(loginBtn) && AppUtil.checkElement(userName);
	}


	/*private boolean checkErrorMessagePresentElement(WebElement errorMsg2) {
		try{
			return errorMsg.isDisplayed();
		}catch(Exception e){
			return false;
		}
	}*/


}

