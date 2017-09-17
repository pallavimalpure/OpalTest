package com.test.pageactions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.test.config.ConfigHelper;
import com.test.keywords.KeyWordDrivenActions;
import com.test.pageobjects.CreateUserPageObject;

public class CreateUser extends KeyWordDrivenActions
{
	//test git
	String elementPath = null;
	String elementValue = null;
	
	public String createUser(WebDriver driver) throws InterruptedException
	{
		  CreateUserPageObject pageObject = new CreateUserPageObject(driver);
		  
		  click(pageObject.orderOpalCard);
		  
		  Thread.sleep(1000);
			
		  driver.findElement(By.xpath("//span[text() = 'I want to order an Adult Opal card']")).click();

		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.linkText("Continue ordering an Opal card")).click();
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  String titlePath = ConfigHelper.getGetconfig().getTitlePath();
		  elementValue = "Mrs.";
		  selectDropDown(driver,titlePath, elementValue);
			
		  driver.findElement(By.xpath("//input[@id = 'firstName']")).sendKeys("TestFirstName");
		  driver.findElement(By.xpath("//input[@id = 'lastName']")).sendKeys("TestLastname");
		  driver.findElement(By.xpath("//input[@name = 'address.address1']")).sendKeys("Test Address");
		  driver.findElement(By.xpath("//input[@id = 'address-citySuburb']")).sendKeys("London");
		  driver.findElement(By.xpath("//input[@id = 'address-stateProvinceRegion']")).sendKeys("England");
			
		  driver.findElement(By.xpath("//input[@id = 'address-postcodeZip']")).sendKeys("SE10 0BP");
		  
		  String countryPath = ConfigHelper.getGetconfig().getCountryPath();
		  elementValue = "United Kingdom";
		  selectDropDown(driver,countryPath, elementValue);
		  
		  String DobDayPath = ConfigHelper.getGetconfig().getDobDayPath();
		  elementValue = "4";
		  selectDropDown(driver,DobDayPath, elementValue);
		  
		  String DobMonthPath = ConfigHelper.getGetconfig().getDobMonthPath();
		  elementValue = "7";
		  selectDropDown(driver,DobMonthPath, elementValue);
		  
		  String DobYearPath = ConfigHelper.getGetconfig().getDobYearPath();
		  elementValue = "1987";
		  selectDropDown(driver,DobYearPath, elementValue);
		  
		  driver.findElement(By.xpath("//input[@id = 'emailAddress']")).sendKeys("pallavimalpure@gmail.com");
			
		  driver.findElement(By.xpath("//input[@id = 'mobilePhone']")).sendKeys("+61449176475");
			
		  driver.findElement(By.xpath("//input[@id = 'userName']")).sendKeys("TestUsername");
		  driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("TestPAssword");
		  driver.findElement(By.xpath("//input[@id = 'confirmPassword']")).sendKeys("TestPAssword");
			
		  driver.findElement(By.xpath("//input[@id = 'opalPin']")).sendKeys("1234");
			
		  String secQuestionPath = ConfigHelper.getGetconfig().getSecQuestionsPath();
		  elementValue = "First school you attended";
		  selectDropDown(driver,secQuestionPath, elementValue);
		  
		  driver.findElement(By.id("securityAnswer")).sendKeys("Rachana");
			
		  driver.findElement(By.id("accept")).click();
			
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  driver.findElement(By.name("_eventId_next")).click();
			
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		  String act = driver.findElement(By.id("recaptcha_response_field.errors")).getText();

		  return act;			
	}
}
