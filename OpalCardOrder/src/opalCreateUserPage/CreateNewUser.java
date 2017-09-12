package opalCreateUserPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import KeyWords.KeyWordDrivenActions;
import config.ConfigHelper;

public class CreateNewUser extends KeyWordDrivenActions
{
	KeyWordDrivenActions keyAction;
	String elementPath = null;
	String elementValue = null;
	
	public String createUser(WebDriver driver) throws InterruptedException
	{
		  keyAction = new KeyWordDrivenActions();
		
		  driver.findElement(By.xpath("//span[text() = 'Order an Opal card']")).click();
		  Thread.sleep(1000);
			
		  driver.findElement(By.xpath("//span[text() = 'I want to order an Adult Opal card']")).click();

		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.findElement(By.linkText("Continue ordering an Opal card")).click();
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  String titlePath = ConfigHelper.getGetconfig().getTitlePath();
		  elementValue = "Mrs.";
		  keyAction.selectDropDown(driver,titlePath, elementValue);
			
		  driver.findElement(By.xpath("//input[@id = 'firstName']")).sendKeys("TestFirstName");
		  driver.findElement(By.xpath("//input[@id = 'lastName']")).sendKeys("TestLastname");
		  driver.findElement(By.xpath("//input[@name = 'address.address1']")).sendKeys("Test Address");
		  driver.findElement(By.xpath("//input[@id = 'address-citySuburb']")).sendKeys("London");
		  driver.findElement(By.xpath("//input[@id = 'address-stateProvinceRegion']")).sendKeys("England");
			
		  driver.findElement(By.xpath("//input[@id = 'address-postcodeZip']")).sendKeys("SE10 0BP");
		  
		  String countryPath = ConfigHelper.getGetconfig().getCountryPath();
		  elementValue = "United Kingdom";
		  keyAction.selectDropDown(driver,countryPath, elementValue);
		  
		  String DobDayPath = ConfigHelper.getGetconfig().getDobDayPath();
		  elementValue = "4";
		  keyAction.selectDropDown(driver,DobDayPath, elementValue);
		  
		  String DobMonthPath = ConfigHelper.getGetconfig().getDobMonthPath();
		  elementValue = "7";
		  keyAction.selectDropDown(driver,DobMonthPath, elementValue);
		  
		  String DobYearPath = ConfigHelper.getGetconfig().getDobYearPath();
		  elementValue = "1987";
		  keyAction.selectDropDown(driver,DobYearPath, elementValue);
		  
		  driver.findElement(By.xpath("//input[@id = 'emailAddress']")).sendKeys("pallavimalpure@gmail.com");
			
		  driver.findElement(By.xpath("//input[@id = 'mobilePhone']")).sendKeys("+61449176475");
			
		  driver.findElement(By.xpath("//input[@id = 'userName']")).sendKeys("TestUsername");
		  driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("TestPAssword");
		  driver.findElement(By.xpath("//input[@id = 'confirmPassword']")).sendKeys("TestPAssword");
			
		  driver.findElement(By.xpath("//input[@id = 'opalPin']")).sendKeys("1234");
			
		  String secQuestionPath = ConfigHelper.getGetconfig().getSecQuestionsPath();
		  elementValue = "First school you attended";
		  keyAction.selectDropDown(driver,secQuestionPath, elementValue);
		  
		  driver.findElement(By.id("securityAnswer")).sendKeys("Rachana");
			
		  driver.findElement(By.id("accept")).click();
			
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		  driver.findElement(By.name("_eventId_next")).click();
			
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		  String act = driver.findElement(By.id("recaptcha_response_field.errors")).getText();

		  return act;			
	}
}
