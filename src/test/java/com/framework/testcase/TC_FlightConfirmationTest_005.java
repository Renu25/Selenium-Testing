package com.framework.testcase;

import java.io.IOException;

import org.testng.annotations.Test;

import com.framework.pageobjects.FlightConfirmationPage;

public class TC_FlightConfirmationTest_005 extends BaseClass
{

	@Test
	public void test() throws IOException
	{
	FlightConfirmationPage e= new FlightConfirmationPage(driver);
	captureScreenshot(driver, "FlightConfirmationPage");
	e.signoff();
	}
	
	
}
