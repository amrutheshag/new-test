package com.org.actiTime.actiTime;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users 
{
	public static final Logger log=Logger.getLogger(Users.class.getName());
	WebDriver driver;
	public Users(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id ="ext-gen7")
	WebElement userButton;
	
	@FindBy(id ="userDataLightBox_firstNameField")
	WebElement firstName;
	
	@FindBy(id ="userDataLightBox_middleNameField")
	WebElement middleName;
	
	@FindBy(id ="userDataLightBox_lastNameField")
	WebElement lastName;
	
	@FindBy(id ="userDataLightBox_emailField")
	WebElement email;
	
	@FindBy(id ="userDataLightBox_usernameField")
	WebElement username;
	
	@FindBy(id ="userDataLightBox_passwordField")
	WebElement password;
	
	@FindBy(id ="userDataLightBox_passwordCopyField")
	WebElement retypePassword;
	
	
	@FindBy(xpath =".//button[contains(text(),'department not assigned')]")
	WebElement selectDepartment;
	
	@FindBy(xpath =".//body/div[5]/ul/li[2]")
	WebElement newDepartment;
	
	@FindBy(id ="userDataLightBox_newUserGroupNameField")
	WebElement departmentName;
	
	@FindBy(id ="userDataLightBox_submitOtherUserTimeTrackChBox")
	WebElement modifyUserTimeTrack;
	
	@FindBy(xpath =".//label[contains(text(),'Manage Customers & Projects')]")
	WebElement manageCustomersandProjects;
	
	@FindBy(xpath =".//label[contains(text(),'Manage Tasks')]")
	WebElement  manageTasks;
	
	@FindBy(id ="userDataLightBox_generateTimeReportsLabel")
	WebElement generateTimeReportsLabel;
	
	@FindBy(id ="userDataLightBox_generateMoneyReportsLabel")
	WebElement generateMoneyReportsLabel;
	
	@FindBy(id ="userDataLightBox_manageAccountsLabel")
	WebElement manageAccountsLabel;
	
	@FindBy(id ="userDataLightBox_manageGeneralSettingsChBox")
	WebElement umanageGeneralSettings;
	
	@FindBy(xpath =".//div[contains(text(),'Create User')]")
	WebElement createUser;
	
	@FindBy(id ="userDataLightBox_deleteBtn")
	WebElement deleteUser;
	
	@FindBy(xpath =".//*[@id='userDataLightBox_footer']/table/tbody/tr/td[1]/span")
	WebElement erroMessage;
	
	@FindBy(id ="userDataLightBox_cancelBtn")
	WebElement cancelButton;
	
	
	
	
	public void createUser(String firstName,String midlleName,String lastName,String email,String username,String password,String timeTrack,String reporting,String taskManagement
,String userManagement)
	{
		userButton.click();
		log.info("click in login button and object is "+ userButton.toString());
		this.firstName.sendKeys(firstName);
		log.info("entered item firstName:- "+firstName+" and object is "+ this.firstName.toString());
		this.middleName.sendKeys(midlleName);
		log.info("entered item midlleName:- "+midlleName+" and object is "+ this.middleName.toString());
		this.lastName.sendKeys(lastName);
		log.info("entered item lastName:- "+lastName+" and object is "+ this.lastName.toString());
		this.email.sendKeys(email);
		log.info("entered item email:- "+email+" and object is "+ this.email.toString());
		this.username.sendKeys(username);
		log.info("entered item username:- "+username+" and object is "+ this.username.toString());
	    this.password.sendKeys(password);
	    log.info("entered password:- "+password+" and object is "+ this.password.toString());
	    retypePassword.sendKeys(password);
	    log.info("entered retypePassword:- "+password+" and object is "+ retypePassword.toString());
		if(timeTrack.equalsIgnoreCase("yes"))
		{
			modifyUserTimeTrack.click();
			log.info("click on modify User TimeTrack and object is "+ modifyUserTimeTrack.toString());
		}
		if(reporting.equalsIgnoreCase("yes"))
		{
			generateTimeReportsLabel.click();
			log.info("click on generate Time Reports and object is "+ generateTimeReportsLabel.toString());
			generateMoneyReportsLabel.click();
			log.info("click on generate Money Reports and object is "+ generateMoneyReportsLabel.toString());
		}
		if(taskManagement.equalsIgnoreCase("yes"))
		{
			 manageCustomersandProjects.click();
			 log.info("click on generate Time Reports and object is "+ manageCustomersandProjects.toString());
			 manageTasks.click();
			 log.info("click on manageTasks and object is "+ manageTasks.toString());
		}
		if(userManagement.equalsIgnoreCase("yes"))
		{
			manageAccountsLabel.click();
			log.info("click on manage Accounts and object is "+ manageAccountsLabel.toString());
			umanageGeneralSettings.click();
			log.info("click on umanage General Settings and object is "+ umanageGeneralSettings.toString());
		}
		createUser.click();
		log.info("click on create User button and object is "+ createUser.toString());
	}
	public void deleteUse(String username)
	{
		 WebElement edituser = driver.findElement(By.xpath(".//div[contains(text(),'"+username+"')]/../../td[5]"));
		 edituser.click();
		log.info("select User:-"+username+" and object is "+ edituser.toString());
		deleteUser.click();
		Alert alert=driver.switchTo().alert();
		String getMessage=alert.getText();
		log.info("get message:- "+ getMessage);
		alert.accept();
		log.info("click on ok");
	
	}
	
	
	
	
	
	
}
