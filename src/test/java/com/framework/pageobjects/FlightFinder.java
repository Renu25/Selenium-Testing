package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class FlightFinder 
{

	WebDriver driver;
	
	Select dr,deptstn,frmmnt,fday, arrstn,TTomonth,TTDay,Arilines;
	public FlightFinder(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how= How.XPATH, using="//body//b//input[1]")
	WebElement typeradiobtn;
	
	@FindBy(how= How.NAME , using="passCount")
	WebElement  paxcount;
	
	@FindBy(how= How.NAME , using="fromPort")
	WebElement  departstation;
	
	@FindBy(how= How.NAME , using="fromMonth")
	WebElement  frommonth;
	
	@FindBy(how= How.NAME , using="fromDay")
	WebElement  fromday;
	
	@FindBy(how= How.NAME , using="toPort")
	WebElement  arrivingstation;
	
	@FindBy(how= How.NAME , using="toMonth")
	WebElement tomonth ;
	
	@FindBy(how= How.NAME , using="toDay")
	WebElement  today;
	
	@FindBy(how= How.NAME , using="servClass")
	WebElement  serclass;
	
	@FindBy(how= How.NAME , using="airline")
	WebElement  airline;
	
	@FindBy(how= How.NAME , using="findFlights")
	WebElement  searchbtn;
	
	
	public void selectRadioBtn()
	{
		typeradiobtn.click();
	}
	
	public void selectNumPax(String pax) {
	dr= new Select(paxcount);
	dr.selectByValue(pax);
	}
	
	public void selectDepartStation(String text)
	{
		deptstn= new Select(departstation);
		deptstn.selectByVisibleText(text);
	}
	
	public void selectFromMonth(String month)
	{
		frmmnt= new Select(frommonth);
		frmmnt.selectByVisibleText(month);
	}
	
	public void selectFromDay(String day)
	{
		fday= new Select(fromday);
		fday.selectByValue(day);
	}
	
	public void selectArrStn(String arrvstn)
	{
		arrstn= new Select(arrivingstation);
		arrstn.selectByVisibleText(arrvstn);
	}
	
	public void selectToMonth(String ToMonth)
	{
		TTomonth= new Select(tomonth);
		TTomonth.selectByVisibleText(ToMonth);
	}
	
	public void selectToDay(String ToDy)
	{
		TTDay= new Select(today);
		TTDay.selectByValue(ToDy);
	}
	
	public void selectServiceClass()
	{
		serclass.click();
	}
	
	public void selectAirline(String airLLine)
	{
		Arilines= new Select(airline);
		Arilines.selectByVisibleText(airLLine);
	}
	
	public void clickOnContinue()
	{
		searchbtn.click();
	}
}
