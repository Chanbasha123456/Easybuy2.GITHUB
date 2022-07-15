package com.easbuy.tests;

import org.testng.annotations.Test;

public class Group_ex2 {
  @Test(groups={"smoke","regression"})
  public void Test4() {
	  System.out.println("Test Method 4");
  }
  @Test(groups={"sanity","regression"})
  public void Test5()
  {
	  System.out.println("Test Method 5");
  }
  @Test(groups="regression")
  public void Test6()
  {
	  System.out.println("Test Method 6");
  }
}
