package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FlightConfirmationPage 
{

	WebDriver driver;
	
	public FlightConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how= How.XPATH, using="//a[contains(text(),'SIGN-OFF')]")
	WebElement signoff;
	
	public void signoff()
	{
		signoff.click();
	}
	
}
