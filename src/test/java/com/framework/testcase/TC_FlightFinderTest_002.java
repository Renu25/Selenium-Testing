package com.framework.testcase;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.pageobjects.FlightFinder;
import com.framework.utilities.XLUtils;

public class TC_FlightFinderTest_002 extends BaseClass 
{
	@Test(dataProvider="Flight")
	public void FlightFinder(String pax, String dep, String dmnt, String dday, String arr, String tmnt, String tday, String airl ) throws InterruptedException, IOException
	{		
		FlightFinder ff= new FlightFinder(driver);
		Thread.sleep(3000);
		//ff.selectRadioBtn();
		ff.selectNumPax(pax);
		Thread.sleep(2000);
		ff.selectDepartStation(dep);
		ff.selectFromMonth(dmnt);
		ff.selectFromDay(dday);
		ff.selectArrStn(arr);
		Thread.sleep(2000);
		ff.selectToMonth(tmnt);
		ff.selectToDay(tday);
		ff.selectServiceClass();
		ff.selectAirline(airl);
		Thread.sleep(2000);
		captureScreenshot(driver, "FlightFinderPage");
		ff.clickOnContinue();
	}
	
	@DataProvider(name="Flight")
	String[][] getDataforflight() throws IOException
	{
		String path=  System.getProperty("user.dir")+ "\\src\\test\\java\\com\\framework\\testdata\\Data.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Flightfinder");
		int columncount= XLUtils.getCellCount(path, "Flightfinder",1);

		String logindata1[][]= new String[rownum-1][columncount];
		
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				logindata1[i-1][j]=XLUtils.getCellData(path, "Flightfinder", i, j);	
			}
		}
		
		return logindata1;
	}

}
