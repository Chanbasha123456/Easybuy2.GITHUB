package com.easbuy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample_Test2 {

	@Test
	
	public void loginhrm()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO'\\Downloads\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		  driver.findElement(By.id("btnLogin")).click();
		  System.out.println(driver.getTitle());
		  driver.quit();
		
	}
	@Test
	public void loginswaglabs()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO'\\Downloads\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.saucedemo.com");
		  driver.findElement(By.id("user-name")).sendKeys("standard_user");
		  driver.findElement(By.id("password")).sendKeys("secret_sauce");
		  driver.findElement(By.id("login-button")).click();
		//WebElement cart= driver.findElement(By.cssSelector(".shopping_cart_link"));
		 // Assert.assertTrue(cart.isDisplayed());
		  WebElement producttitle= driver.findElement(By.cssSelector(".title"));
		  String text = producttitle.getText();
		Assert.assertNotEquals(text,"PRODUCTS","Test not matched");
		
		  driver.quit();
	}
}
