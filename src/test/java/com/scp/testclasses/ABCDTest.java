package com.scp.testclasses;

import org.testng.annotations.Test;

public class ABCDTest {

	@Test(groups={"xtest"})
	public void x1(){
		System.out.println("x1 test");
	}

	
	@Test(groups={"xtest"},dependsOnMethods="xyzs")
	public void x2(){
		System.out.println("x2 test");
	}
	
	
	@Test(groups={"smoke","xtest"})
	public void a1(){
		System.out.println("a1 test");
	}
	
	
}
