package com.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.config.ConfigHelper;

public class LoginPageObject 
{
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	String userName = ConfigHelper.getGetconfig().getLoginUsername();
	@FindBy(xpath =".//input[@id = 'userName']")
	public WebElement opalUserName;

	String loginPassword = ConfigHelper.getGetconfig().getLoginPassword();
	@FindBy(xpath =".//input[@id = 'loginPassword']")
	public WebElement opalPassword;
	
	String logIn = ConfigHelper.getGetconfig().getLogIn();
	@FindBy(xpath =".//input[@value = 'logIn']")
	public WebElement opalLoginSubmit;
}
