package opalLoginPage;

import org.openqa.selenium.WebDriver;

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
