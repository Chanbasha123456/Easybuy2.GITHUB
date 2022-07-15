package com.easbuy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.easybaypages.Login_page;
import com.easybaypages.Login_page2;

public class Login_Swaglabs2 {
	@Test
	public void loginswaglabs()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO'\\Downloads\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.saucedemo.com");
		 Login_page2  loginpage = PageFactory.initElements(driver,Login_page2.class);
		 loginpage.loginapp("standard_user", "secret_sauce");
		
		  
		  
		WebElement cart= driver.findElement(By.cssSelector(".shopping_cart_link"));
		 Assert.assertTrue(cart.isDisplayed());
		  
		  
		
		  driver.quit();
	}
}


