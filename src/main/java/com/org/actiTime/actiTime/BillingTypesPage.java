package com.org.actiTime.actiTime;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BillingTypesPage
{

	
	public static final Logger log=Logger.getLogger(Users.class.getName());
	WebDriver driver;
	public BillingTypesPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[@class='popup_menu_icon settings_icon']")
	WebElement settingsIcon;
	
	@FindBy(linkText="Billing Types")
	WebElement billingTypesLink;
	
	@FindBy(id="ext-comp-1002")
	WebElement createBillingTypeButton;	
	
	@FindBy(className="successmsg")
	WebElement msg;
	
	@FindBy(id="name")
	WebElement nameTextBox;
	
	@FindBy(css="input[type='submit']")
	WebElement createBillingTypeButtonSubmiteButton;
	
	public void navigateToBillingTypesPage()
	{
		settingsIcon.click();
		log.info("click on Settings Icon button and object is "+ settingsIcon.toString());
		billingTypesLink.click();
		log.info("click on Billing Types Link and object is "+ billingTypesLink.toString());
	}
	
	public void createNewBillingTypePage(String billingName)
	{
		
		createBillingTypeButton.click();
		log.info("click on Create Billing Type Button and object is "+ createBillingTypeButton.toString());
		nameTextBox.sendKeys(billingName);
		log.info("entered item firstName:- "+billingName+" and object is "+ nameTextBox.toString());
		createBillingTypeButtonSubmiteButton.click();
		log.info("click on Create Billing Type Submite Button and object is "+ createBillingTypeButtonSubmiteButton.toString());
	}
	public void verifyBilling(String expectedMsg)
	{		
		String actualMsg = msg.getText();
		log.info("get Message:- "+actualMsg+" and object is "+ msg.toString());
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	public void deleteBilling(String billingName)
	{
		 WebElement deleteBillingLink = driver.findElement(By.xpath(".//a[text()='"+billingName+"']/../../td[7]/a"));
		 deleteBillingLink.click();
		 log.info("click on delete Billing type "+billingName+" and object is "+ deleteBillingLink.toString());
		 Alert alert=driver.switchTo().alert();
		 String alertMessage=alert.getText();
		 log.info("alert Message "+alertMessage);
		 alert.accept();
		 log.info("click on ok Button ");
	}
	
	
	
	
}
