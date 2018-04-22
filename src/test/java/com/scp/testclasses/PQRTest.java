package com.scp.testclasses;

import org.testng.annotations.Test;

/**
 * 
 * you need to check Testclass name -- by alphabetical order
 * -- then check testmethod names by alphabetical--
 * 
 * 
 * 
 * @author Yogesh
 *
 */




public class PQRTest {
	
  @Test()
  public void xyzs() {
	  System.out.println("inside test1 -- DATABASE Connection");
	 // int i=10/0;
  }
  
  
  @Test(dependsOnMethods="xyzs",alwaysRun=true)
  public void test2() {
	  System.out.println("inside test2");
  }
  
  @Test(dependsOnMethods="xyzs")
  public void test3() {
	  System.out.println("inside test3");
  }
  
  @Test(dependsOnMethods="xyzs")
  public void test4() {
	  System.out.println("inside test4");
  }
  
  
  
}
