package com.scp.appconstants;

public class Remarks {

	/**
	 * Presequisites
	 * 		-- Make sure your project is pointing to jdk8
	 * 
	 * 
	 * 
	 * 
	 * Selenium -- 2.X   -- jdk7 pn chalel  -- Selenium2
	 * Selenium -- 3.X   -- jdk8 pn chalel  -- Selenium3
	 * 
	 * 
	 * S2 -- 
	 * 		--Firefox Is default browser -- 
	 * 		--version should less than 47
	 * 		--No need set explicit system property with driver
	 * S3 -- 
	 * 		--Firefox Is not default browser 
	 * 		-- version should less than 52
	 * 		--you need set explicit system property which is pointing to geckodriver 
	 * 
	 * Apache maven - 3.x  
	 * 			-- Download and set MAVEN_HOME = root folder of maven without bin
	 * 				and path should have %MAVEN_HOME%\bin
	 * 			-- open fresh command prompt and type mvn
	 * 			-- so that .m2 will be created inside user's directory,will have repository
	 * 				folder will be there...however you need to place settins.xml
	 * 				
	 * 			-- Build automation tool
	 * 			-- resolves transitive dependecies
	 * 			-- Every developer will get same versions of jar files as we are going to 
	 * 				share pom.xml (Project object model) and settings.xml.
	 * repository	
	 * 			-- maven's default Local repository location is .m2 folder which is inside
	 * 				user's directory
	 * 
	 * 
	 * 
	 * Add selenium dependency as i have firefox 56 version using 
	 * 		selenium 3.4.0  -- To interact with browser
	 * 		testng  6.10   -- for assertation purpose (Check actual result with expected +
	 * 			reporting)
	 * 
	 * 
	 * 			
	 * 
	 * 			
	 * 
	 * 
	 * 
	 * 
	 * Types of seleniumFramework
	 * Module bases
	 * Library Architecture
	 * Data Driver
	 * Keyword driver
	 * Hybrid
	 * BDD
	 * 
	 * MLDKHB -- Meaning fule name 
	 * KLM BDH --- 
	 * 
	 * Module Based
	 * 		-- modularity -- sepearate out business logic and test logic as per modules
	 * 		e.g -- login invoice reporting xyz etc
	 * AD
	 * 		Module bases so easy to maintain and scalable
	 * DS  -- While passing test data we need to pass across modules
	 * 
	 * Library Architecure
	 * 		-- Seperate common functionlity acroos the modules 
	 * Ad
	 * 		-- Core reusability
	 * 		-- Modularity
	 * DS
	 * 		-- If fails will affect entire entire applicaiton
	 * 
	 * DataDriven
	 * 			-- your data lies inside either in files- excel csv and text or in dbs
	 *  		-- you write a class  which will read data and pass it to test cases
	 *AD -- if data changes no need to make changes in code
	 *		easy to maintain test data as it seperate from the code
	 *DS --
	 *		We need to be dependent on third party to read the data
	 *		MYSQL  -- MYSQL JAR
	 *		Excel -- eXCLE JARS poi
	 * 
	 * keywordDriven
	 * 		--Your data(keyword) lis in excelsheet
	 * 			Test Description Keyword locator
	 * AD
	 * 		-- same keyword can be used in multiple test scenarios
	 * 		-- 
	 * DS
	 * 	  -- We need to be dependent on third party to read the data
	 *     -- If any of the keyword/locator gets changed will affect dependent test scenarios 
 	 * 
	 * 
	 * 
	 * Hybrid
	 * 	-- combination of any two or more frameworks is nothing but hybrid
	 * 
	 * 	AD -
	 * DI
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
}
