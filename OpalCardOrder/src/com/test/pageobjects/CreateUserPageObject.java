package com.test.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.config.ConfigHelper;

public class CreateUserPageObject 
{
	WebDriver driver;
	
	public CreateUserPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	String orderAnOpalCard = ConfigHelper.getGetconfig().getOrderAnOpalCard();
	@FindBy(xpath ="//span[text() = 'Order an Opal card']")
	public WebElement orderOpalCard;

}