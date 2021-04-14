package com.framework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookFlight
{
	WebDriver driver;
	public BookFlight(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	Select meal,card,month,year;
	
@FindBy(how= How.NAME, using="passFirst0")
WebElement firstnametxt;

@FindBy(how= How.NAME, using="passLast0")
WebElement lastnametxt;

@FindBy(how= How.NAME, using="pass.0.meal")
WebElement mealselectbox;

@FindBy(how= How.NAME, using="creditCard")
WebElement creditcard;

@FindBy(how= How.NAME, using="creditnumber")
WebElement cardnumber;

@FindBy(how= How.NAME, using="cc_exp_dt_mn")
WebElement exprymonth;

@FindBy(how= How.NAME, using="cc_exp_dt_yr")
WebElement expryyear;

@FindBy(how= How.NAME, using="cc_frst_name")
WebElement creditfrstname;

@FindBy(how= How.NAME, using="cc_mid_name")
WebElement creditmidlename;

@FindBy(how= How.NAME, using="cc_last_name")
WebElement creditlastname;

//@FindBy(how= How.XPATH, using="//tr[8]//td[2]//input[1]")
//WebElement ticketless;


@FindBy(how= How.XPATH, using="//font[contains(text(),'Ticketless Travel')]")
WebElement ticketless;


@FindBy(how= How.NAME, using="billAddress1")
WebElement bilingaddr;

@FindBy(how= How.NAME, using="billCity")
WebElement billcity;

@FindBy(how= How.NAME, using="billState")
WebElement state;

@FindBy(how= How.NAME, using="billZip")
WebElement pincode;

@FindBy(how= How.NAME, using="billCountry")
WebElement country;

@FindBy(how= How.XPATH, using="//font[contains(text(),'Same as Billing')]")
WebElement sameaddress;


@FindBy(how=How.NAME, using="buyFlights")
WebElement contin;

public void SelectFirstname(String ffname)
{
	//firstnametxt.sendKeys(fname);
	firstnametxt.sendKeys(ffname);
}

public void SelectLastname(String lname)
{
	lastnametxt.sendKeys(lname);
}

public void SelectMeals(String value)
{
	meal= new Select(mealselectbox);
	meal.selectByVisibleText(value);
}

public void selectCard(String cardtype) 
{
card= new Select(creditcard);
card.selectByVisibleText(cardtype);
}

public void cardNumber(String cardnum)
{
	cardnumber.sendKeys(cardnum);
}

public void selectmonth(String emonth)
{
	//month= new Select(exprymonth);
	//month.selectByVisibleText(emonth);
	
	Select oSelect = new Select(exprymonth);
	List <WebElement> elementCount = oSelect.getOptions();
	System.out.println(elementCount.size());
	elementCount.get(5);
}

public void selectyear(String eyear)
{
	year= new Select(expryyear);
	year.selectByValue(eyear);
}

public void cardfirstname(String cfname)
{
	creditfrstname.sendKeys(cfname);
}

public void cardfmidlename(String cmname)
{
	creditmidlename.sendKeys(cmname);
}

public void cardlastname(String clname)
{
	creditlastname.sendKeys(clname);
}

public void SelectTicketless()
{
		ticketless.click();
}

public void SelectAddress(String add)
{
	bilingaddr.clear();
	bilingaddr.sendKeys(add);
}

public void SelectCity(String city)
{
	billcity.clear();
	billcity.sendKeys(city);
}

public void SelectState(String bstate)
{
	state.clear();
	state.sendKeys(bstate);
}

public void SelectPincode(String zip)
{
	pincode.clear();
	pincode.sendKeys(zip);
}


public void SelectCountry(String bcounrty)
{
	country.sendKeys(bcounrty);
}

public void Selectsameaddr()
{
	sameaddress.click();
}

public void SelectContinue()
{
	contin.click();
}
}
