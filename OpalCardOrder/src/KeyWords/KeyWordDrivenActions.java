package KeyWords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
	
	
}


