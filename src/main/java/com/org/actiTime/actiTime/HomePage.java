package com.org.actiTime.actiTime;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	public  final String timeTrack = "Time-Track";
	public  final String tasks = "Tasks";
	public  final String reports = "Reports";
	public  final String users = "Users";
	public  final String workschedule = "Work Schedule";
	public  final String notifications = "Notifications";
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	 
	public void homePage(String smenu)
	{
		WebElement moduleName=driver.findElement(By.xpath(".//div[contains(text(),'"+smenu+"')]"));
		moduleName.click();
		log.info("click on module Name:-"+smenu+"and object is "+moduleName.toString());
	}
	
		
		
	
	
}
