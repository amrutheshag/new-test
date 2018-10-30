package com.org.actiTime.actiTime;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public static final Logger log=Logger.getLogger(LoginPage.class.getName());
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	WebElement username;

	@FindBy(name="pwd")
	WebElement password;

	@FindBy(id="loginButton")
	WebElement login;

	
	
	@FindBy(xpath=".//*[@id='ErrorsTable']/tbody/tr/td[2]/table/tbody/tr/td/span")
	WebElement errorMessage;

	
	public void loginpage(String username,String password)
	{
		
		this.username.sendKeys(username);
		log.info("entered item username:- "+username+" and object is "+ this.username.toString());
	    this.password.sendKeys(password);
	    log.info("entered password:- "+password+" and object is "+ this.password.toString());
		login.click();
		log.info("click in login button and object is "+ login.toString());
		
	}
	
}
