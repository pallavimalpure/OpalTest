package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Config helper class
public class ConfigHelper 
{
	private String url = null;
	private String filePath = null;
	private String titlePath = null;
	private String countryPath = null;
	private String dobDayPath = null;
	private String dobMonthPath = null;
	private String dobYearPath = null;
	private String secQuestionPath = null;			
	
	InputStream input = null;
	
	static ConfigHelper getconfig = new ConfigHelper();
	
	public static ConfigHelper getGetconfig() {
		return getconfig;
	}

	public String getUrl() 
	{
		return url;
	}

	public String getFilePath() 
	{
		return filePath;
	}

	public String getTitlePath() 
	{
		return titlePath;
	}

	public String getCountryPath() 
	{
		return countryPath;
	}

	public String getDobDayPath() 
	{
		return dobDayPath;
	}

	public String getDobMonthPath()
	{
		return dobMonthPath;
	}

	public String getDobYearPath() 
	{
		return dobYearPath;
	}

	public String getSecQuestionsPath() 
	{
		return secQuestionPath;
	}

	private ConfigHelper()
	{
		ReadProperties();
	}
	
	private void ReadProperties()
	{
		Properties prop = new Properties();
		try 
		{
			input = new FileInputStream("config.properties");
			prop.load(input);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		url = prop.getProperty("url");
		filePath = prop.getProperty("filepath");
		titlePath = prop.getProperty("titlePath");
		countryPath = prop.getProperty("countryPath");
		dobDayPath = prop.getProperty("dobDayPath");
		dobMonthPath = prop.getProperty("dobMonthPath");
		dobYearPath = prop.getProperty("dobYearPath");
		secQuestionPath = prop.getProperty("secQuestionPath");
	}
	
}
