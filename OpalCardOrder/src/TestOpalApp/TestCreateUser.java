package TestOpalApp;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CreateNewUser.CreateUserPage;
import config.ConfigHelper;
import junit.framework.Assert;

public class TestCreateUser 
{
	WebDriver driver;
	String appURL = null;
	
	  @Test
	  public void isUserCreated() 
	  {
		  CreateUserPage createUser = new CreateUserPage();
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
