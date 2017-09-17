package com.test.testscripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.config.ConfigHelper;
import com.test.keywords.KeyWordDrivenActions;
import com.test.pageactions.CreateUser;

public class TestCreateUser 
{
	WebDriver driver;
	String appURL = null;
	
	  @Test
	  public void isUserCreated() 
	  {
		  CreateUser createUser = new CreateUser();
		  try 
		  {
			String exp = "Please complete the security words field";
			String act = createUser.createUser(driver);
			Assert.assertEquals(exp, act);
		  } 
		  catch (InterruptedException e) 
		  {
			e.printStackTrace();
		  }
	  }
	  
	 @BeforeClass
	  public void LoadWebPage() throws IOException 
	  {	  
		  KeyWordDrivenActions actions = new KeyWordDrivenActions();
		  
		  driver = actions.openBrowser(driver);
		  
		  appURL = ConfigHelper.getGetconfig().getUrl();
		  
		  driver.get(appURL);
		  driver.manage().window().maximize();
	  }

	  @AfterClass
	  public void afterTest() 
	  {
		  driver.close();
	  }

}
