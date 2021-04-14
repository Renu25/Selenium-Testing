 package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using="userName")
	WebElement txtusername;
	
	@FindBy(how= How.NAME, using= "password")
	WebElement txtpassword;
	
	@FindBy(how= How.NAME, using= "login")
	WebElement signinbtn;
	
	@FindBy(how= How.XPATH, using= "//a[contains(text(),'SIGN-OFF')]")
	WebElement Signout;
	
	public void username(String username)
	{
		txtusername.sendKeys(username);
	}
	
	public void password(String pass)
	{
		txtpassword.sendKeys(pass);
	}

	public void clickOnSubmit() 
	{
	signinbtn.click();	
	}
	
	public void clickOnSignout() 
	{
		Signout.click();	
	}
}
