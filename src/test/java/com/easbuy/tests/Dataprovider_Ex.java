package com.easbuy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_Ex {
	
  @Test(dataProvider="logindetails")
  public void loginswaglabs(String testType, String uname, String pwd) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO'\\Downloads\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com");
	  driver.findElement(By.id("user-name")).sendKeys(uname);
	  driver.findElement(By.id("password")).sendKeys(pwd);
	  driver.findElement(By.id("login-button")).click();
	  if(testType.equals("valid"))
	  {
		  
			WebElement cart= driver.findElement(By.cssSelector(".shopping_cart_link"));
			  Assert.assertTrue(cart.isDisplayed());
	  }
	  else
	  {
		  WebElement errormsg = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		  String actualerrortext = errormsg.getText();
		  String actualexpectedtext="Epic sadface: Username and password do not match any user in this service";
		  Assert.assertEquals(actualexpectedtext,actualerrortext);
	  }
	  
	  //WebElement producttitle= driver.findElement(By.cssSelector(".title"));
	  //String text = producttitle.getText();
	//Assert.assertNotEquals(text,"PRODUCTS","Test not matched");
	
	  driver.quit();
  }

@DataProvider(name="logindetails")
public Object[][] logindata()
{
	Object[][] data = new Object[2][3];
	data[0][0]="valid";
	data[0][1]="standard_user";
	data[0][2]="secret_sauce";
	
	data[1][0]="Invalid";
	data[1][1]="chan";
	data[1][2]="Mercy";
	
	return data;
}
}
