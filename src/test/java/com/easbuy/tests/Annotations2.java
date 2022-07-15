package com.easbuy.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations2 {
	WebDriver driver;
	@BeforeMethod
	public void launchtheapplication()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO'\\Downloads\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.saucedemo.com");
	}
	@Test(priority=2)
	public void loginswaglabs() {
		
		  driver.findElement(By.id("user-name")).sendKeys("standard_user");
		  driver.findElement(By.id("password")).sendKeys("secret_sauce");
		  driver.findElement(By.id("login-button")).click();
		  WebElement producttitle= driver.findElement(By.cssSelector(".title"));
		  String text = producttitle.getText();
		Assert.assertEquals(text,"PRODUCTS");
	
	}
 @Test(priority=1)
 public void verifycart()
 {
	 driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();
	  WebElement cart= driver.findElement(By.cssSelector(".shopping_cart_link"));
	 Assert.assertTrue(cart.isDisplayed());
 }
 @AfterMethod
 public void closebrowser()
 
 
 {
	 driver.quit();
 }
 }

