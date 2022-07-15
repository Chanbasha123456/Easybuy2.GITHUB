package com.easbuy.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider_Ex2 {
	
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
public Object[][] logindata() throws Exception
{
	Object[][] data = new Object[2][3];
	File file = new File("C:\\Users\\LENOVO'\\eclipse-workspace\\easybuy_AT\\src\\test\\resources\\Testdata\\login.xlsx");
	FileInputStream fi= new FileInputStream(file);
	XSSFWorkbook wb= new XSSFWorkbook(fi);
	XSSFSheet sheet = wb.getSheetAt(0);
    int rows =	sheet.getPhysicalNumberOfRows();
    //System.out.println(rows);
   int columns = sheet.getRow(0).getLastCellNum();
   
   //System.out.println(columns);
   for(int i=0; i<rows-1;i++)
   {
	   for(int j=0; j<columns;j++)
	   {
		data[i][j]=   sheet.getRow(i+1).getCell(j).getStringCellValue();
		 //  String celldata = sheet.getRow(i).getCell(j).getStringCellValue();
		   //System.out.print(celldata+" ");
	   }
	   //System.out.println();
	   
   }
   wb.close();
	return data;
}
}
