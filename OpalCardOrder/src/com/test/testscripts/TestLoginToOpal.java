package com.test.testscripts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.config.ConfigHelper;
import com.test.getdata.*;
import com.test.keywords.KeyWordDrivenActions;
import com.test.pageactions.LoginPageAction;
import com.test.pageobjects.LoginPageObject;

public class TestLoginToOpal 
{
	WebDriver driver;
	String appURL = null;
	LoginDAO loginDAO = new LoginDAO();
	LoginPageAction pageActions;
	LoginPageObject pageObject;
	KeyWordDrivenActions actions = new KeyWordDrivenActions();
	
  @Test(dataProvider = "getRowData")
  public void testLoginToOpal(Integer n, LoginData logData) 
  {
	  	pageActions = new LoginPageAction(driver);
	    pageActions.logintoOpal(logData);
	  
	  try 
	  {
		Class.forName("com.mysql.jdbc.Driver");
	  } catch (ClassNotFoundException e1) 
	  {
		e1.printStackTrace();
	  }
	  
	  Connection con = null;
	  
	  try 
	  {
		String query = String.format("INSERT INTO userdetails (userid, userpassword)  VALUES ('%s', '%s');",logData.userId,logData.password);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelgeek","admin","admin123");
		Statement stmt = con.createStatement();
		stmt.execute(query);	
	  } catch (SQLException e) 
	  {
		e.printStackTrace();
	  }
	  finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  
	  actions.clear(pageObject.opalUserName);
	  actions.clear(pageObject.opalPassword);
  }

  @DataProvider
  public Object[][] getRowData() 
  {
	  LoginData data = null;
	  try 
	  {
		 data = loginDAO.getLoginDetailsForId(2);
	  }
	  catch (IOException e) 
	  {
		e.printStackTrace();
	  }
	  
	  return new Object[][]
	  {
		new Object[] { data.rowId, data },
	  };	
  }
  
  @BeforeClass
  public void LoadWebPage() throws IOException 
  {	  
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
