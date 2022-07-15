package com.easbuy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class swaglabs 
{
	WebDriver driver;
	@Parameters("browser")
  @Test
  public void openBrowser(String browserName)
  
  { 
		String browser=browserName.toUpperCase();
	  if(browser.equals("CHROME"))
	  {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO'\\Downloads\\chromedriver.exe");
	  driver=new ChromeDriver();
	  }
	  else if(browser.equals("EDGE"))
	  {
		  System.setProperty("webdriver.edge.driver", "C:\\Users\\LENOVO'\\Downloads\\msedgedriver.exe");
		  driver=new EdgeDriver();
	  }
	  driver.manage().window().maximize();
  }
  @Parameters("appurl")
  @Test
  public void launchapplication(String url)
  {
	  driver.get(url);
  }
  @Parameters({"username","Password"})
  @Test
  public void enterUsernameandPassword(String uname, String pwd)
  {
	  driver.findElement(By.id("user-name")).sendKeys(uname); 
	  driver.findElement(By.id("password")).sendKeys(pwd);  
  }
   @Test
  public void clickLogin()
  {
	  driver.findElement(By.id("login-button")).click();
  }
  @Test
  public void verifyLogin()
  {
	  WebElement producttitle= driver.findElement(By.cssSelector(".title"));
	  String text = producttitle.getText();
	  Assert.assertEquals(text,"PRODUCTS");
  }
}

