package com.org.actiTime.actiTime;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

	public static final Logger log=Logger.getLogger(LogoutPage.class.getName());
	WebDriver driver;
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="logoutLink")
	WebElement logoutLink;
	
	
	public Boolean verifyLogout()
	{
		try {
			logoutLink.isDisplayed();
			log.info("logout is dispalyed and object is:-"+logoutLink.toString());
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	public void logout()
	{
		logoutLink.click();
		log.info("click in logout and object is "+ logoutLink.toString());
	}
}
