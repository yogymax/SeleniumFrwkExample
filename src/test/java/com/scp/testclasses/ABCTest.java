package com.scp.testclasses;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.scp.util.excereadwrite.MyTestReportCountListener;


@Listeners(value=MyTestReportCountListener.class)
public class ABCTest {

	@Test(groups={"a","smoke"},invocationCount=10)
	public void m1(){
		System.out.println("m1 test");
	}
	
	
	@Test(groups={"a","smoke"},priority=1)
	public void m2(){
		System.out.println("m2 test");
	}
	
	
	
	
	@Test(groups={"a"},priority=1,dependsOnMethods="m4")
	public void m3(){
		System.out.println("m3 test");
	}
	
	@Test(invocationCount=100)
	public void m4() throws Exception{
		throw new Exception("failed...");
	}
	
	
}
