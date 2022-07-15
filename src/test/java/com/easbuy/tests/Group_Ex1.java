package com.easbuy.tests;

import org.testng.annotations.Test;

public class Group_Ex1 {
  @Test(groups="regression")
  public void Test1() {
	  System.out.println("Test Method 1");
	  
  }
  @Test(groups={"sanity","smoke"})
  public void Test2()
  {
	  System.out.println("Test Method 2");
  }
  @Test(groups="regression")
  public void Test3()
  {
	  System.out.println("Test Method 3");
  }
}
