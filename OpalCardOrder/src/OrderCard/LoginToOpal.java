package OrderCard;

import org.testng.annotations.Test;

import POMObjectRepository.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginToOpal {
	
	WebDriver driver;
	String appURL = null;
	LoginDAO loginDAO = new LoginDAO();
	OpalPageAction pageActions;
	
  @Test(dataProvider = "getRowData")
  public void testLoginToOpal(Integer n, LoginData logData) 
  {
	  	pageActions = new OpalPageAction(driver);
	    pageActions.logintoOpal(logData);
	  //driver.findElement(By.xpath(".//input[@id = 'h_username']")).sendKeys(logData.userId);
	  //driver.findElement(By.id("h_password")).sendKeys(logData.password);
	  //driver.findElement(By.className("button")).click();
	  
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
  
  @Test(dataProvider = "getDataForAllRows",enabled = false)
  public void loginToOpalForAllUsers(HashMap<Integer, LoginData> data) 
  {
	  for(LoginData temp : data.values())
	  {
		  driver.findElement(By.id("h_username")).sendKeys(temp.userId);
		  driver.findElement(By.id("h_password")).sendKeys(temp.password);
		  driver.findElement(By.className("button")).click(); 
		  driver.findElement(By.id("h_username")).clear();
		  driver.findElement(By.id("h_password")).clear();
	  }
	  
  }
  @DataProvider
  public Object[][] getDataForAllRows() 
  {
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
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\yewal\\Desktop\\Selenium Java\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  appURL = ConfigHelper.getGetconfig().getUrl();
	  
	  driver.get(appURL);
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  //driver.close();
  }


}
