package com.scp.web.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.scp.util.AppContracts;

public class DashboardPageObject implements AppContracts {
	
	@FindBy(id="welcome")
	WebElement welcome;
	
	@FindBy(className="menu")
	WebElement menu;

	
	public boolean isPageLoaded() {
		return AppUtil.checkElement(welcome);
	}
	
}
