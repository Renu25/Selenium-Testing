package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {
	
	WebDriver driver;
	public SelectFlight(WebDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements(driver, this);
	}

	@FindBy(how= How.XPATH, using="//table//table//table//table//table[1]//tbody[1]//tr[5]//td[1]//input[1]")
	WebElement depart; 
	
	@FindBy(how= How.XPATH, using="//table[2]//tbody[1]//tr[5]//td[1]//input[1]")
	WebElement arrival;
	
	@FindBy(how= How.NAME,using="reserveFlights")
	WebElement submit;
	
	public void ClickOnDepart()
	{
		depart.click();
	}
	
	public void ClickOnarrival()
	{
		arrival.click();
	}
	public void ClickOnContinue()
	{
		submit.click();
	}
	
}
