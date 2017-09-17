package com.test.pageactions;

import org.openqa.selenium.WebDriver;

import com.test.getdata.LoginData;
import com.test.pageobjects.LoginPageObject;

public class LoginPageAction 
{
	WebDriver driver;
	LoginPageObject pageObject;
	
	public LoginPageAction(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void logintoOpal(LoginData logData)
	{
		  pageObject =  new LoginPageObject(driver);
		  pageObject.opalUserName.sendKeys(logData.userId);
		  pageObject.opalPassword.sendKeys(logData.password);
		  //pageObject.opalLoginSubmit.click();
		  pageObject.opalUserName.clear();
		  pageObject.opalPassword.clear();
	}
}
