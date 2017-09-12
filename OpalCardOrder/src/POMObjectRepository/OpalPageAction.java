package POMObjectRepository;

import org.openqa.selenium.WebDriver;

import OrderCard.LoginData;

public class OpalPageAction 
{
	WebDriver driver;
	OpalPageObject pageObject;
	
	public OpalPageAction(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void logintoOpal(LoginData logData)
	{
		  pageObject =  new OpalPageObject(driver);
		  pageObject.opalUserName.sendKeys(logData.userId);
		  pageObject.opalPassword.sendKeys(logData.password);
		  //pageObject.opalLoginSubmit.click();
	}
}
