package com.scp.util.excereadwrite;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestReportCountListener implements ITestListener {

	static int passCount=0;
	static int failCount=0;
	static int skipCount=0;
	
	
	public void onFinish(ITestContext arg0) {
		System.out.println("Test execution completed...!");
		ExcelReadWriteUtil.generatePieChart(passCount,failCount,skipCount);
		System.out.println("Pass Execution count --- " +passCount);
		System.out.println("Fail Execution count --- " +failCount);
		System.out.println("Skip Execution count --- " +skipCount);
		try {
			ExcelReadWriteUtil.writeTestCountIntoExcel(passCount, skipCount, failCount);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onStart(ITestContext arg0) {
		System.out.println("Test excecution started...!");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("This --- "+arg0.getTestName() +" test case has failed...!");
		failCount++;
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("This --- "+arg0.getTestName() +" test case has skipped...!");
		skipCount++;
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("This --- "+arg0.getTestName() +" test case execution started...!");
	}

	public void onTestSuccess(ITestResult arg0) {
		System.out.println("This --- "+arg0.getTestName() +" test case has succeed...!");
		passCount++;
	}

}
