package com.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;


public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src= new File("./configuration/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
//			pro.load(new FileInputStream(System.getProperty("user.dir")+ "\\log4j.properties/"));
//			pro.setProperty("log4j.appender.File.File", "\\logs/" + "test2logs");
			String log4jConfPath = "C:\\Users\\India\\Documents\\Selenium\\AutomationFramework\\DDAutomationFramework\\log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			
		}catch(Exception e)
		{
			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username= pro.getProperty("username");
		return username;
	}
	
	
	public String getPassword()
	{
		String pwd= pro.getProperty("password");
		return pwd;
	}
	
	public String getChromepath()
	{
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefox()
	{
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEPath()
	{
		String IEpath= pro.getProperty("iepath");
		return IEpath;
	}
}
