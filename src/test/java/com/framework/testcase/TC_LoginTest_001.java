package com.framework.testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.pageobjects.LoginPage;
import com.framework.utilities.XLUtils;

public class TC_LoginTest_001 extends BaseClass {

	WebElement nxtpage;
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pass) throws IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.username(user);
	lp.password(pass);
	captureScreenshot(driver, "LoginPage");
	lp.clickOnSubmit();
	
	if(IsDisplayed()==false)
	{
		captureScreenshot(driver, "LoginErrorPage");
		AssertJUnit.assertTrue(false);
	}
	else
	{
	   AssertJUnit.assertTrue(true);
		//captureScreenshot(driver, "LoginErrorPage");		
		
	}
	}
	
	
	public boolean IsDisplayed()
	{
		try {
		nxtpage=driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]"));
		if(nxtpage.isDisplayed()==true)
		{
		return true;
		}
		}
		catch(Exception e)
		{
			return false;
		}
		return false;
	}
	

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=  System.getProperty("user.dir")+ "\\src\\test\\java\\com\\framework\\testdata\\Data.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Login");
		int columncount= XLUtils.getCellCount(path, "Login",1);
		
		String logindata[][]= new String[rownum][columncount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Login", i, j);	
			}
		}
		return logindata;
	}
	
}
