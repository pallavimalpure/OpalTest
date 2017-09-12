package POMObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpalPageObject 
{
	WebDriver driver;
	
	public OpalPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath =".//input[@id = 'h_username']")
	public WebElement opalUserName;

	@FindBy(xpath =".//input[@id = 'h_password']")
	public WebElement opalPassword;
	
	@FindBy(xpath =".//input[@className = 'button']")
	public WebElement opalLoginSubmit;
}
