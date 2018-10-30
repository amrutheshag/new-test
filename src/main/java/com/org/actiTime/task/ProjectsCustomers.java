package com.org.actiTime.task;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProjectsCustomers 
{
	public static final Logger log=Logger.getLogger(ProjectsCustomers.class.getName());
	 WebDriver driver;
		
		public ProjectsCustomers(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="ext-gen7")
		WebElement customer;
		
		@FindBy(name="name")
		WebElement customername;
		
		@FindBy(name="description")
		WebElement description;
		
		@FindBy(name="createCustomerSubmit")
		WebElement customersubmitbutton;
		
		@FindBy(id="ext-gen14")
		WebElement project;
		
		@FindBy(name="customerId")
		WebElement selectcustomer;
		
		@FindBy(name="createProjectSubmit")
		WebElement createProjectSubmit;
		
		
		@FindBy(xpath=".//label[contains(text(),'Create a new project for this customer')]")
		WebElement createNewProjectForThisCustomer;
		
		@FindBy(xpath=".//label[contains(text(),'Add more customers')]")
		WebElement addMoreCustomer;
		
		@FindBy(id="SuccessMessages")
		WebElement successMessages;
		
		
		
		
		
		public void createCustomers(String customername,String description)
		{
			customer.click();
			log.info("click on create customer button and object is "+ customer.toString());
			this.customername.sendKeys(customername);
			log.info("entered customername:- "+customername+" and object is "+ this.customername.toString());
			this.description.sendKeys(description);
			log.info("entered customer description:- "+description+" and object is "+ this.description.toString());
			customersubmitbutton.click();
			log.info("click on customer submite button and object is "+ customersubmitbutton.toString());
			String successMessage1=successMessages.getText();
			log.info("success Message1"+successMessage1+" and object is "+ customersubmitbutton.toString());
		}
		
		public boolean verifySuccessMessage()
		{
			try {
				successMessages.isDisplayed();
				log.info("create customer success Messages page dispalyed and object is:-"+successMessages.toString());
				return true;
			} catch (Exception e) {
	            return false;
			}
		}
		public void createProject(String customername,String projectnamename,String description)
		{
			project.click();
			log.info("click on create project button and object is "+ project.toString());
			Select select=new Select(selectcustomer);
			log.info("click select class object to perforam action drop down element" );
			select.selectByVisibleText(customername);
			log.info(" select customer:- "+customername+" and object is "+ this.customername.toString());
			this.customername.sendKeys(projectnamename);
			log.info("entered project name:- "+projectnamename+" and object is "+ this.customername.toString());
			this.description.sendKeys(description);
			log.info("entered project description:- "+description+" and object is "+ this.description.toString());
			createProjectSubmit.click();
			log.info("click on project submite button and object is "+ createProjectSubmit.toString());
			String successMessage1=successMessages.getText();
			log.info("success Message1"+successMessage1+" and object is "+ customersubmitbutton.toString());
		}
	
		
		public void createCustomersAndProject(String customername,String description,String projectnamename,String description1)
		{
			customer.click();
			log.info("click on create customer button and object is "+ customer.toString());
			this.customername.sendKeys(customername);
			log.info("entered customername:- "+customername+" and object is "+ this.customername.toString());
			this.description.sendKeys(description);
			log.info("entered customer description:- "+description+" and object is "+ this.description.toString());
			createNewProjectForThisCustomer.click();
			log.info("click on create NewProject For This Customer radio button and object is "+ createNewProjectForThisCustomer.toString());
			customersubmitbutton.click();
			log.info("click on customer submite button and object is "+ customersubmitbutton.toString());
			String successMessage1=successMessages.getText();
			log.info("success Message1"+successMessage1+" and object is "+ successMessages.toString());
			this.customername.sendKeys(projectnamename);
			log.info("entered project name:- "+projectnamename+" and object is "+ this.customername.toString());
			this.description.sendKeys(description1);
			log.info("entered project description:- "+description1+" and object is "+ this.description.toString());
			createProjectSubmit.click();
			log.info("click on project submite button and object is "+ createProjectSubmit.toString());
			String successMessage2=successMessages.getText();
			log.info("success Message1"+successMessage2+" and object is "+ successMessages.toString());
		}
}
