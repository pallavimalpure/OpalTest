package com.test.testscripts;

import org.testng.annotations.Test;

import com.test.config.ConfigHelper;
import com.test.getdata.*;
import com.test.keywords.KeyWordDrivenActions;
import com.test.pageactions.LoginPageAction;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TestMultipleLoginToOpal 
{

	WebDriver driver;
	String appURL = null;
	
  @Test(dataProvider = "getDataForAllRows")
  public void loginToOpalForAllUsers(HashMap<Integer, LoginData> data) 
  {
	  LoginPageAction pageActions = new LoginPageAction(driver);

	    
	  for(LoginData temp : data.values())
	  {
		  pageActions.logintoOpal(temp);
	  }
	  
  }
  @DataProvider
  public Object[][] getDataForAllRows() 
  {
	  LoginDAO loginDAO = new LoginDAO();
	  HashMap<Integer, LoginData> data = null;
	  try 
	  {
		 data = loginDAO.getLoginDetails();
	  }
	  catch (IOException e) 
	  {
		e.printStackTrace();
	  }
	  
	  return new Object[][]
	  {
		new Object[] { data },
	  };
  }
	  
  @BeforeTest
  public void LoadWebPage() throws IOException 
  {	  
	  KeyWordDrivenActions actions = new KeyWordDrivenActions();
	  
	  driver = actions.openBrowser(driver);
	  
	  appURL = ConfigHelper.getGetconfig().getUrl();
	  
	  driver.get(appURL);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
