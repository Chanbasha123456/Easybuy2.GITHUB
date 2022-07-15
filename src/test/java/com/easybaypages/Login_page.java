package com.easybaypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page {
	WebDriver driver;
	
	By username = By.id("user-name");
	By password = By.id("password");
	By login = By.id("login-button");
	public Login_page(WebDriver driver)
	{
		this.driver = driver;
	}
	public void enterusername() {
		driver.findElement(username).sendKeys("standard_user");
	}
	public void enterpassword() {
		driver.findElement(password).sendKeys("secret_sauce");
	}
	public void loginbutton()
	{
		driver.findElement(login).click();
	}
	
}
