package com.easybaypages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class Login_page2 {
	@FindBy(id="user-name")
	WebElement username;
	@FindBy(how=How.ID,using="password")
	WebElement pass;
	
	@FindBy(how=How.ID,using="login-button")
	WebElement login;
	/*public void enterusername(String uname) {
		username.sendKeys(uname);
	}
	public void enterpassword(String passwrd) {
		pass.sendKeys(passwrd);*/
	//}
	public void loginbutton()
	{
		login.click();
	}
	public void loginapp(String uname, String passwrd)
	{
		username.sendKeys(uname);
		pass.sendKeys(passwrd);
		loginbutton();
		
	}
	
	}
