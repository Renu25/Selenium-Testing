 package com.framework.testcase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.framework.utilities.ReadConfig;

import com.framework.testcase.SendMail;

public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	public static WebDriver driver;
	public String baseURL= readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
public static Logger logger;

   @BeforeTest
	@Parameters("browser")
	public void setup(String br)
	{
		
//		logger=Logger.getLogger("ebanking");
//		PropertyConfigurator.configure("Log4j.properties");
		
		
		if(br.equals("chrome"))
		{
	System.setProperty("webdriver.chrome.driver",readconfig.getChromepath()  );
	//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\Drivers\\chromedriver.exe");
	driver= new ChromeDriver();
		}

		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefox());
			driver= new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(baseURL);
	}
	
	@AfterSuite
	public void teardown()
	{
		
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ss= (TakesScreenshot)driver;
		File source=ss.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public static String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
	}
	
	@AfterSuite
	public void execute() throws Exception
	{
		SendMail.execute("test-output//emailable-report.html");
	}
}

