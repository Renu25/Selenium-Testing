package com.framework.testcase;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.framework.pageobjects.SelectFlight;

public class TC_SelectFlightTest_003 extends BaseClass
{
	@Test(priority=0)
	public void SelectFlightPage() throws InterruptedException, IOException
	{
		SelectFlight sf= new SelectFlight(driver);
		Thread.sleep(2000);
		sf.ClickOnDepart();
		sf.ClickOnarrival();
		captureScreenshot(driver, "SelectFlightPage");
		sf.ClickOnContinue();
		
	}
}
