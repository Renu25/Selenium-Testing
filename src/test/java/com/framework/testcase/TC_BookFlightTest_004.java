package com.framework.testcase;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import com.framework.pageobjects.BookFlight;
import com.framework.utilities.XLUtils;

public class TC_BookFlightTest_004 extends BaseClass
{

	@Test(dataProvider="Bookflight")
	public void BookFlight(String ffname, String llname, String vvalue, String ccardtype, String ccardnum, String cemonth, String ceyear, String cfcname,String cmcname, String clcname, String addres, String ccity, String bcstate, String czip, String bccounrty) throws InterruptedException, IOException
	{		
		//Thread.sleep(3000);
		BookFlight bf= new BookFlight(driver);
		Thread.sleep(3000);
		bf.SelectFirstname(ffname);
		bf.SelectLastname(llname);
		bf.SelectMeals(vvalue);
		Thread.sleep(2000);
		bf.selectCard(ccardtype);
		bf.cardNumber(ccardnum);
		bf.selectmonth(cemonth);
		bf.selectyear(ceyear);
		bf.cardfirstname(cfcname);
		bf.cardfmidlename(cmcname);
		bf.cardlastname(clcname);
		bf.SelectTicketless();
		bf.SelectAddress(addres);
		bf.SelectCity(ccity);
		bf.SelectState(bcstate);
		bf.SelectPincode(czip);
		bf.SelectCountry(bccounrty);
		bf.Selectsameaddr();
		captureScreenshot(driver, "BookFlightPage");
		bf.SelectContinue();
	}
	
	
	
	@DataProvider(name="Bookflight")
	String[][] getDataforBooking() throws IOException
	{
		String path=  System.getProperty("user.dir")+ "\\src\\test\\java\\com\\framework\\testdata\\Data.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "BookFlightPage");
		int columncount= XLUtils.getCellCount(path, "BookFlightPage",1);

		String flightdata[][]= new String[rownum][columncount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				flightdata[i-1][j]=XLUtils.getCellData(path, "BookFlightPage", i, j);	
			}
		}
		
		return flightdata;
	}

	
	
}
