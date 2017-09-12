package TestOpalApp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.ConfigHelper;
import opalLoginPage.LoginDAO;
import opalLoginPage.LoginData;
import opalLoginPage.LoginPageAction;

public class TestLoginToOpal 
{
	WebDriver driver;
	String appURL = null;
	LoginDAO loginDAO = new LoginDAO();
	LoginPageAction pageActions;
	
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
	  
	  driver.findElement(By.id("h_username")).clear();
	  driver.findElement(By.id("h_password")).clear();
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
  
  @BeforeTest
  public void LoadWebPage() throws IOException 
  {	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\yewal\\Desktop\\Selenium Java\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
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
