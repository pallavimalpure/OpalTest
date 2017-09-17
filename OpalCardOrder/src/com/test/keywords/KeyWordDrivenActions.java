package com.test.keywords;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.test.config.ConfigHelper;

public class KeyWordDrivenActions 
{
	//WebDriver driver;
	
	public void selectRadioButton(WebDriver driver,String elementPath)
	{
		driver.findElement(By.xpath(elementPath)).click();
	}
	
	public void selectDropDown(WebDriver driver,String elementPath, String elementValue)
	{
		WebElement element = driver.findElement(By.xpath(elementPath));
		Select selElement = new Select(element);
		selElement.selectByValue(elementValue);
	}
	
	public void selectListBox(WebDriver driver,String elementPath, String elementValue)
	{
		WebElement element = driver.findElement(By.xpath(elementPath));
		Select selElement = new Select(element);
		selElement.selectByValue(elementValue);
	}
	
	public void selectCheckBox(WebDriver driver,String elementPath)
	{
		driver.findElement(By.xpath(elementPath)).click();
	}
	
	public void click(WebElement element)
	{
		element.click();
	}
	
	public void Implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void enterText(WebDriver driver,String elementPath,String enterText)
	{
		driver.findElement(By.xpath(elementPath)).sendKeys(enterText);
	}
	
	public String getText(WebDriver driver,String elementPath)
	{
		String getText = driver.findElement(By.xpath(elementPath)).getText();
		return getText;
	}
	
	public void clear(WebElement element)
	{
		element.clear();
	}
	
	public WebDriver openBrowser(WebDriver driver)
	{
		String browserExe = ConfigHelper.getGetconfig().getBrowserExe();
		String browserDriver = ConfigHelper.getGetconfig().getBrowserDriver();
		System.setProperty(browserDriver,browserExe);

		if (browserDriver.equalsIgnoreCase("webdriver.chrome.driver"))
		{
			driver = new ChromeDriver();
		}
		return driver;
			
	}
	
}


