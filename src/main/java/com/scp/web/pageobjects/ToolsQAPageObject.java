package com.scp.web.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import com.scp.appconstants.ApplicationConstants;
import com.scp.appconstants.WebDriverInitialization;

public class ToolsQAPageObject {
	
	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(name="sex")
	List<WebElement> genderType;
	
	@FindBy(name="exp")
	List<WebElement> yearsOfExp;
	
	@FindBy(id="datepicker")
	WebElement date;
	
	@FindBy(name="profession")
	List<WebElement> profession;
	
	@FindBy(id="photo")
	WebElement profilePicture;
	
	@FindBy(name="tool")
	List<WebElement> automationTools;
	
	@FindBy(id="continents")
	WebElement continents;
	
	@FindBy(id="selenium_commands")
	WebElement seleniumCommands;
	
	public void enterUserData(String firstnm,String lastnm){
		firstName.clear();
		firstName.sendKeys(firstnm);
		
		lastName.clear();
		lastName.sendKeys(lastnm);
	}
	
	public void selectGender(ApplicationConstants.GenderTypes gender){
		if(gender==null){
			Assert.fail("Invalid gender type");
			return;
		}
		
		for(WebElement item :genderType){
			if(item.getAttribute("value").equals(gender.toString())){
				item.click();
				break;
			}
		}
	}
	
	public void yearOfExp(int yearExp){
		
		if(yearExp <=0 || yearExp >60){
			Assert.fail("Invalid year of exp...!");
		}
		
		for(WebElement item :yearsOfExp){
			if(Integer.parseInt(item.getAttribute("value"))==yearExp){
				item.click();
				break;
			}
		}
	}
	
	
	public void enterDate(String p_date){
		date.clear();
		date.sendKeys(p_date);
	}
	
	
	public void selectProfession(String ...listOfProf){
		for (String prof : listOfProf) {
			for (WebElement item : profession) {
				if(item.getAttribute("value").equals(prof)){
					item.click();
					break;
				}
			}
			
		}
	}
	
	
	public void selectAutomationTools(String ...autoTools){
		for (String tool : autoTools) {
			for (WebElement item : automationTools) {
				if(item.getAttribute("value").equals(tool)){
					item.click();
					break;
				}
			}
			
		}
	}

	
	
	public void uploadFile(String path){
		// PENDING
		//usingRobotClasses(path);
		usingAUTOITV3(path); //make sure path is of .exe bcoz file path is already their in script
		//usingSikuli(path);
		/**
		 * Robot classes
		 * AutoIT v3
		 * Sikuli
		 */
	}

	private void usingSikuli(String path) {
		// TODO Auto-generated method stub
		//FilepathInput.png
		//openBtn.png
		profilePicture.click();
		Screen screen = new Screen();
		Pattern filepath = new Pattern("C:\\Users\\Yogesh\\Desktop\\Patterns\\FilepathInput.PNG");
		Pattern openbtn = new Pattern("C:\\Users\\Yogesh\\Desktop\\Patterns\\openBtn.PNG");

		try {
			screen.type(filepath,path);
			screen.click(openbtn);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void usingAUTOITV3(String path) {
		/**
		 * Install AUTOITV3 Third party tool
		 * 
		 * open Script Editer from start menu
		 * 
		 *  write a script and find the screen elements using finder tool provided
		 *  by AUTOITv3
		 *  
		 *  
		 *  Save the script extention will be .au3
		 *  right click on .au3 file and compile script
		 *  
		 *  if sytanctically everything is correct one .exe will be created
		 *  that .exe file you need to run using java
		 * 
		 * 
		 * 
WinWaitActive("File Upload")
Send("C:\Users\XYZ\Desktop\J\test.txt")
Send("{ENTER}")
		 * 
		 */
		
			profilePicture.click();
			WebDriverInitialization.launchProgram(path);
	}

	private void usingRobotClasses(String path) {
		WebDriverInitialization.copyContentInSystemClipboard(path);
		profilePicture.click(); 
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void selectCountry(String countryName){
		Select countryDropDown = new Select(continents);
		countryDropDown.selectByVisibleText(countryName);
	}
	
	public void selectSeleniumCommands(String ...cmds){
		Select selectCommands = new Select(seleniumCommands);
		for (String cmd : cmds) {
			selectCommands.selectByVisibleText(cmd);
		}
	}
	
	

}
